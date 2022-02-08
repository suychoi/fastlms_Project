package com.example.fastlms_project.main.notice.service;

import com.example.fastlms_project.admin.notice.dto.NoticeDto;
import com.example.fastlms_project.admin.notice.model.NoticeParam;

import java.util.List;

public interface MainNoticeService {
    //공지 목록 가져오기
    List<NoticeDto> mainNoticeList(NoticeParam parameter);
}
