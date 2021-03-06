package com.example.fastlms_project.admin.mail.service;

import com.example.fastlms_project.admin.mail.dto.MailDto;
import com.example.fastlms_project.admin.mail.model.MailParam;
import com.example.fastlms_project.admin.mail.entity.Mail;
import com.example.fastlms_project.admin.mail.mapper.MailMapper;
import com.example.fastlms_project.admin.mail.model.MailRegister;
import com.example.fastlms_project.admin.mail.repository.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService{

    private final MailRepository mailRepository;
    private final MailMapper mailMapper;

    @Override
    public boolean mailRegister(MailRegister parameter) {
        Optional<Mail> optionalMail = mailRepository.findById(parameter.getMailKey());
        if(optionalMail.isPresent()){
            return false;
        }

        Mail mail = Mail.builder()
                .mailKey(parameter.getMailKey())
                .mailTitle(parameter.getMailTitle())
                .mailContents(parameter.getMailContents())
                .build();

        mailRepository.save(mail);

        return true;
    }

    @Override
    public boolean mailEdit(MailRegister parameter) {
        Optional<Mail> optionalMail = mailRepository.findById(parameter.getMailKey());
        //stream 과 filter를 사용해보기
        if (!optionalMail.isPresent()){
            return false;
        }

        Mail mail = optionalMail.get();
                mail.setMailKey(parameter.getMailKey());
                mail.setMailTitle(parameter.getMailTitle());
                mail.setMailContents(parameter.getMailContents());

        mailRepository.save(mail);

        return true;
    }

    @Override
    public List<MailDto> mailList(MailParam parameter) {
        long totalCount = mailMapper.mailCount(parameter);

        List<MailDto> list = mailMapper.mailList(parameter);
        if (!CollectionUtils.isEmpty(list)){
            int i = 0;
            for (MailDto x : list){
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }

        return list;
    }

    @Override
    public MailDto mailGetDetail(String mailKey) {
        return mailRepository.findById(mailKey).map(MailDto::of).orElse(null);
    }

    @Override
    public boolean mailDelete(String idList) {
        //null check에 대한 exception handler 필요
        String[] keys = idList.split(",");
            for(int x=0; x < keys.length; x++){
            mailRepository.deleteById(keys[x]);
        }

        return true;
    }
}
