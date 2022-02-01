package com.example.fastlms_project.admin.mail.service;

import com.example.fastlms_project.admin.mail.dto.MailDto;
import com.example.fastlms_project.admin.mail.model.MailParam;
import com.example.fastlms_project.admin.mail.model.MailRegister;

import java.util.List;

public interface MailService {

    //메일 템플릿 등록
    boolean mailRegister(MailRegister parameter);

    //메일 템플릿 수정
    boolean mailEdit(MailRegister parameter);

    //메일 목록 가져오기
    List<MailDto> mailList(MailParam param);

    //존재하는 메일 세부내용 가져오기
    MailDto mailGetDetail(String mailKey);

    //선택한 메일 삭제
    boolean mailDelete(String idList);
}
