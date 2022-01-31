package com.example.fastlms_project.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Notice {
    @Id
    private String noticeTitle;

    private String noticeWriter;
    private boolean noticePresentYn;
    private LocalDateTime noticeDueDt;
    private LocalDateTime noticeRegDt;

}
