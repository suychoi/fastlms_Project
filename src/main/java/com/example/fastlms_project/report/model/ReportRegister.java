package com.example.fastlms_project.report.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
public class ReportRegister {
    private String reportNumber;

    private String reporterId;
    private String reporterName;
    private String reporterPhone;

    private String checkRule;               //확인 방법(drop down)
    private LocalDateTime checkDt;      //신고인 확인 일시     //추가
    private LocalDateTime checkRegDt;   //매물등록일             //추가
    private String platform;            //중개플랫폼 업체  //추가
    private String dealType;                //거래형태      //추가
    private String intermediary;                //중개대상물 종류      //추가

    private String reason;              //신고 사유
    private String sellNumber;          //매물 번호
    private String sourceUrl;                 //출처
    private String adress;              //매물 소재지

    private String reportedClass;       //피신고대상자 구분
    private String reportedName;        //피신고대상자 상호
    private String reportedPhone;       //피신고대상자 휴대폰번호
    private String reportedAdress;      //피신고 대상자 소재지

    private String reportContents;      //신고내용
    private String reportFile;
}

