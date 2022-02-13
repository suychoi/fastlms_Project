package com.example.fastlms_project.notice.dto;

import com.example.fastlms_project.notice.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoticeDto {

    private int noticeNumber;

    private boolean noticeStatus;
    private String noticeTitle;
    private int noticeViewCount;

    private String noticeContents;
    private LocalDateTime noticeRegDt;

    long totalCount;
    long seq;

    public static NoticeDto of(Notice notice){
        return NoticeDto.builder()
                .noticeNumber(notice.getNoticeNumber())
                .noticeStatus(notice.isNoticeStatus())
                .noticeTitle(notice.getNoticeTitle())
                .noticeViewCount(notice.getNoticeViewCount())
                .noticeContents(notice.getNoticeContents())
                .noticeRegDt(notice.getNoticeRegDt())
                .build();
    }

    public static List<NoticeDto> of(List<Notice> noticeList){
        if (noticeList == null){
            return null;
        }

    List<NoticeDto> noticeDtoList = new ArrayList<>();
        for(Notice x : noticeList){
            noticeDtoList.add(NoticeDto.of(x));
        }
    return noticeDtoList;
    }
}
