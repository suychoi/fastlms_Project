package com.example.fastlms_project.mail.service;

import com.example.fastlms_project.mail.dto.MailDto;
import com.example.fastlms_project.mail.model.MailParam;
import com.example.fastlms_project.mail.model.MailRegister;

import java.util.List;

public interface MailService {

    //메일 템플릿 등록
    boolean mailRegister(MailRegister parameter);

    //메일 템플릿 수정
    boolean mailEdit(MailRegister parameter);

    //메일 목록 가져오기
    List<MailDto> list(MailParam param);

    //존재하는 메일 세부내용 가져오기
    MailDto getMailByKey(String mailKey);

    //선택한 메일 삭제
    boolean deleteMail(String idList);
}
