package com.example.fastlms_project.components;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Component
public class MailComponents {

    private final JavaMailSender javaMailSender;

    public boolean sendMail(String userEmail, String mailTitle, String mailContents){

        boolean result = false;

        MimeMessagePreparator msg = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelper.setTo(userEmail);
                mimeMessageHelper.setSubject(mailTitle);
                mimeMessageHelper.setText(mailContents, true);
            }
        };

        try {
            javaMailSender.send(msg);
            result = true;

        } catch (Exception e) {
            //Mail 전송 Exception 필요
            System.out.println(e.getMessage());
        }
        return result;
    }
}
