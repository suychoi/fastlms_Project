package com.example.fastlms_project.admin.notice.mapper;

import com.example.fastlms_project.admin.notice.dto.NoticeDto;
import com.example.fastlms_project.admin.notice.model.NoticeParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    //공지사항 Admin
    List<NoticeDto> noticeList(NoticeParam parameter);
    long noticeCount(NoticeParam parameter);

    //공지사항 User
    List<NoticeDto> mainNoticeList(NoticeParam parameter);
    long mainNoticeCount(NoticeParam parameter);
}
