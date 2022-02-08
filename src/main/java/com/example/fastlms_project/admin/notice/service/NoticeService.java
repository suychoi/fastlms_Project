package com.example.fastlms_project.admin.notice.service;

import com.example.fastlms_project.admin.notice.dto.NoticeDto;
import com.example.fastlms_project.admin.notice.model.NoticeParam;
import com.example.fastlms_project.admin.notice.model.NoticeRegister;

import java.util.List;

public interface NoticeService {
    //공지 등록
    boolean noticeRegister(NoticeRegister parameter);

    //공지 수정
    boolean noticeEdit(NoticeRegister parameter);

    //공지 수정 세부내용
    NoticeDto noticeGetDetail(int key);

    //공지 목록 가져오기
    List<NoticeDto> noticeList(NoticeParam param);

    //공지 삭제
    boolean noticeDelete(Integer deleteId);


}
