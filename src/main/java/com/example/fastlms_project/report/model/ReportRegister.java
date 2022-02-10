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

    private String reason;              //신고 사유
    private String check;               //확인 방법(drop down)
    private String url;                 //출처
    private String sellNumber;          //매물 번호
    private String adress;              //매물 소재지

    private String reportedClass;       //피신고대상자 구분
    private String reportedName;        //피신고대상자 상호
    private String reportedPhone;       //피신고대상자 휴대폰번호
    private String reportedAdress;      //피신고 대상자 소재지

    private String reportContents;      //신고내용
    private String reportFile;
}

