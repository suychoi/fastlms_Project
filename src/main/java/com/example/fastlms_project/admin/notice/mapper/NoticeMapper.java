package com.example.fastlms_project.admin.notice.mapper;

import com.example.fastlms_project.admin.notice.dto.NoticeDto;
import com.example.fastlms_project.admin.notice.model.NoticeParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDto> noticeList(NoticeParam parameter);
    long noticeCount(NoticeParam parameter);
}
