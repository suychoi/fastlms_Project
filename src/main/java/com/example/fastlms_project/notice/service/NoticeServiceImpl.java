package com.example.fastlms_project.notice.service;

import com.example.fastlms_project.notice.dto.NoticeDto;
import com.example.fastlms_project.notice.model.NoticeRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    @Override
    public boolean noticeRegister(NoticeRegister parameter) {
        return false;
    }

    @Override
    public NoticeDto noticeGetDetail(int key) {
        return null;
    }
}
