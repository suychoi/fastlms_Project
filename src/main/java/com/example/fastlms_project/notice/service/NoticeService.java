package com.example.fastlms_project.notice.service;

import com.example.fastlms_project.member.model.MemberRegister;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface NoticeService {
    boolean register(MemberRegister parameter);
}
