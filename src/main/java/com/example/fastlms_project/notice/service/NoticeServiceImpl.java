package com.example.fastlms_project.notice.service;

import com.example.fastlms_project.member.model.MemberRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {


    @Override
    public boolean register(MemberRegister parameter) {
        return false;
    }
}
