package com.example.fastlms_project.notice.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
public class NoticeRegister {
    private String noticeTitle;
    private String noticeWriter;
    private LocalDateTime noticeDueDt;
}
