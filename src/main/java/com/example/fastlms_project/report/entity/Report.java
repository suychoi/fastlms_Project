package com.example.fastlms_project.report.entity;

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
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String reportNumber;

    private String reporterId;
    private String reporterName;
    private String reporterPhone;

    private String reason;              //신고 사유
    private String check;               //확인 방법(drop down)
    private String url;                 //출처
    private String sellNumber;          //매물 번호
    private String adress;              //매물 소재지

    private String reportState;
    private String monitoringRule;      //모니터링 방법법
    private LocalDateTime reportDate;   //등록일자
    private LocalDateTime viewDate;     //확인 일자
    private LocalDateTime startDate;    //조사 일자
    private LocalDateTime doneDate;     //종료 일자

    private String reportedClass;       //피신고대상자 구분
    private String reportedName;        //피신고대상자 상호
    private String reportedPhone;       //피신고대상자 휴대폰번호
    private String reportedAdress;      //피신고 대상자 소재지

    private String reportContents;      //신고내용
    private String reportFile;
}
