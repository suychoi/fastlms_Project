package com.example.fastlms_project.component.service;

import com.example.fastlms_project.component.model.MailRegister;
import com.example.fastlms_project.member.model.MemberRegister;

public interface MailService {
    boolean register(MailRegister parameter);
}
