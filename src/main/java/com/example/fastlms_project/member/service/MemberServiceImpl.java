package com.example.fastlms_project.member.service;

import com.example.fastlms_project.member.entity.Member;
import com.example.fastlms_project.member.model.MemberRegister;
import com.example.fastlms_project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public boolean register(MemberRegister parameter) {

        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserEmail());
        if (optionalMember.isPresent()){
            return false;
        }

        String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());

        Member member = Member.builder()
                .userEmail(parameter.getUserEmail())
                .userName(parameter.getUserName())
                .password(encPassword)
                .userPhone(parameter.getUserPhone())
                .build();

        memberRepository.save(member);

        return true;
        //프론트에서 중복확인 필요
    }
}
