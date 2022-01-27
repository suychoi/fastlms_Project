package com.example.fastlms_project.admin.mail.dto;

import com.example.fastlms_project.admin.mail.entity.Mail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MailDto {
    private String mailKey;
    private String mailTitle;
    private String mailContents;

    long totalCount;
    long seq;

    public static MailDto of(Mail mail){
        return MailDto.builder()
                .mailKey(mail.getMailKey())
                .mailTitle(mail.getMailTitle())
                .mailContents(mail.getMailContents())
                .build();
    }

    public static List<MailDto> of(List<Mail> mailList){
        if (mailList == null){
            return null;
        }

    List<MailDto> mailDtoList = new ArrayList<>();
        for(Mail x : mailList){
            mailDtoList.add(MailDto.of(x));
        }
    return mailDtoList;
    }
}
