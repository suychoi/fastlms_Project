package com.example.fastlms_project.member.service;

import com.example.fastlms_project.admin.mail.entity.Mail;
import com.example.fastlms_project.admin.mail.repository.MailRepository;
import com.example.fastlms_project.components.MailComponents;
import com.example.fastlms_project.exception.ExceptionCode;
import com.example.fastlms_project.exception.Exception;
import com.example.fastlms_project.member.entity.Member;
import com.example.fastlms_project.member.exception.MemberNotEmailAuthException;
import com.example.fastlms_project.member.model.MemberRegister;
import com.example.fastlms_project.member.repository.MemberRepository;
import com.example.fastlms_project.report.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;
    private final MailRepository mailRepository;

    public void sendMemberMail(String mailKey, String userEmail, String behave, String linkText){
        //메일 전송메서드
        Optional<Mail> optionalMail = mailRepository.findById(mailKey);
        if(!optionalMail.isPresent()){
            throw new Exception(ExceptionCode.NO_EMAIL_KEY);
        }

        String uuid = UUID.randomUUID().toString();
        String appendText ="<div><a target='_blank' href='http://localhost:8080/member/" + behave + "?id=" + uuid + "'> " + linkText + " </a></div>";

        String mailTitle = optionalMail.get().getMailTitle();
        String mailContents = optionalMail.get().getMailContents().concat(appendText);

        mailComponents.sendMail(userEmail, mailTitle, mailContents);

        Optional<Member> optionalMember = memberRepository.findById(userEmail);

        if(mailKey == "회원가입인증"){
            Member member = optionalMember.get();    // 메일 종류에 따라 다르게 저장필요
            member.setEmailAuthKey(uuid);
            memberRepository.save(member);
        } else if (mailKey == "아이디찾기"){

        } else if (mailKey == "비밀번호초기화"){

        }

    }

    @Override
    public boolean register(MemberRegister parameter) {

        String userEmail = parameter.getUserEmail();

        Optional<Member> optionalMember = memberRepository.findById(userEmail);
        if (optionalMember.isPresent()){
            return false;
        }

        String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());

        Member member = Member.builder()
                .userEmail(userEmail)
                .userName(parameter.getUserName())
                .password(encPassword)
                .userPhone(parameter.getUserPhone())
                .regDt(LocalDateTime.now())
                .emailAuthYn(false)
                .adminRoleYn(false)
                .build();
        memberRepository.save(member);

        sendMemberMail("회원가입인증", userEmail, "email-auth", "이메일 인증 완료");

        return true;
    }

    @Override
    public boolean emailAuth(String uuid) {
        Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(uuid);
        if (!optionalMember.isPresent()){
            return false;
        }

        Member member = optionalMember.get();

        if (member.isEmailAuthYn()){
            return false;
        }

        member.setEmailAuthYn(true);
        member.setEmailAuthDt(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optionalMember = memberRepository.findById(username);
        if(!optionalMember.isPresent()){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        Member member = optionalMember.get();

        if(!member.isEmailAuthYn()){
            throw new MemberNotEmailAuthException("이메일 인증이 필요합니다.");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (member.isAdminRoleYn()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return new User(member.getUserEmail(), member.getPassword(), grantedAuthorities);
    }

    @Override
    public MemberDto reportMemberInfo(String userEmail) {
        Optional<Member> optionalMember  = memberRepository.findById(userEmail);
        if (!optionalMember.isPresent()) {
            return null;
        }

        Member member = optionalMember.get();

        return MemberDto.of(member);
    }

}
