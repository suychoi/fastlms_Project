package com.example.fastlms_project.component.service;

import com.example.fastlms_project.component.entity.Mail;
import com.example.fastlms_project.component.model.MailRegister;
import com.example.fastlms_project.component.repository.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService{

    private final MailRepository mailRepository;

    @Override
    public boolean register(MailRegister parameter) {
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
}
