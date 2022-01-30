package com.example.fastlms_project.member.service;

import com.example.fastlms_project.member.model.MemberRegister;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    boolean register(MemberRegister parameter);
    boolean emailAuth(String uuid);
}
