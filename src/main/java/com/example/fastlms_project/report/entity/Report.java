package com.example.fastlms_project.report.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reportNumber;

    private String reporterId;
    private String reporterName;
    private String reporterPhone;

    private String checkRule;               //확인 방법(drop down)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDt;      //신고인 확인 일시

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkRegDt;   //매물등록일

    private String platform;            //중개플랫폼 업체
    private String dealType;                //거래형태
    private String intermediary;                //중개대상물 종류

    private String reason;              //신고 사유

    private String sourceUrl;                 //출처
    private String sellNumber;          //매물 번호
    private String adress;              //매물 소재지

    private String reportedClass;       //광고 행위자
    private String reportedName;        //피신고대상자 상호
    private String reportedPhone;       //피신고대상자 휴대폰번호
    private String reportedAdress;      //피신고 대상자 소재지

    private String reportState;
    private String monitoringRule;      //모니터링 방법법
    private LocalDateTime reportDate;   //등록일자(접수일자)
    private LocalDateTime viewDate;     //확인 일자
    private LocalDateTime startDate;    //조사 일자
    private LocalDateTime doneDate;     //종료 일자

    @Column(length = 1000)
    private String reportContents;      //신고내용

    private String filename;        // 파일 절대경로
    private String urlFilename;     //파일 상대 경로
}
