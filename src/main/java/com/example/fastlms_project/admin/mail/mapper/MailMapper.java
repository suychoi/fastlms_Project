package com.example.fastlms_project.admin.mail.mapper;

import com.example.fastlms_project.admin.mail.dto.MailDto;
import com.example.fastlms_project.admin.mail.model.MailParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MailMapper {
    List<MailDto> mailList(MailParam parameter);
    long mailCount(MailParam parameter);
}
