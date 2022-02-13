package com.example.fastlms_project.notice.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
public class NoticeRegister {
    private int noticeNumber;
    private String noticeTitle;
    private String noticeContents;
    private boolean noticeStatus;
}
