package com.example.fastlms_project.member.service;

import com.example.fastlms_project.member.model.MemberRegister;
import com.example.fastlms_project.report.dto.MemberDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean register(MemberRegister parameter);

    boolean emailAuth(String uuid);

    //신고 등록시 유저 정보 받아오기 + admin
    MemberDto reportMemberInfo(String userEmail);

}
