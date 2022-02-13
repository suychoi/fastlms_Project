package com.example.fastlms_project.report.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Data
public class ReportManage {
    int reportNumber;

    String reportState;
    String monitoringRule;      //모니터링 방법
    LocalDateTime reportDate;   //등록일자(접수일자)
    LocalDateTime viewDate;     //확인 일자(본 일자)
    LocalDateTime startDate;    //조사 일자(시작)
    LocalDateTime doneDate;     //종료 일자(종료)

    String adUser;            //확인자
    LocalDateTime adDate;            //점검일자
    String resultContents;    //처리결과

}

