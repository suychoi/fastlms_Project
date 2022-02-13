package com.example.fastlms_project.notice.service;

import com.example.fastlms_project.notice.dto.NoticeDto;
import com.example.fastlms_project.notice.model.NoticeParam;

import java.util.List;

public interface MainNoticeService {
    //공지 목록 가져오기
    List<NoticeDto> mainNoticeList(NoticeParam parameter);

    //공지 상세 정보 가져오기
    NoticeDto mainNoticeDetail(int key);
}
