package com.example.fastlms_project.admin.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int noticeNumber;

    private boolean noticeStatus;
    private String noticeTitle;
    private int noticeViewCount;

    private String noticeContents;
    private LocalDateTime noticeRegDt;

}
