package com.example.fastlms_project.mail.service;

import com.example.fastlms_project.mail.dto.MailDto;
import com.example.fastlms_project.mail.model.MailParam;
import com.example.fastlms_project.mail.model.MailRegister;

import java.util.List;

public interface MailService {

    //메일 템플릿 등록
    boolean register(MailRegister parameter);

    //메일 목록 가져오기
    List<MailDto> list(MailParam param);
}
