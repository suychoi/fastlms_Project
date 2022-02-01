package com.example.fastlms_project.notice.service;

import com.example.fastlms_project.member.model.MemberRegister;
import com.example.fastlms_project.notice.dto.NoticeDto;
import com.example.fastlms_project.notice.model.NoticeRegister;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface NoticeService {
    //공지 등록
    boolean noticeRegister(NoticeRegister parameter);

    //공지 수정 세부내용
    NoticeDto noticeGetDetail(int key);


}
