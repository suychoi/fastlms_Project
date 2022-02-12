package com.example.fastlms_project.report.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString
@Data
public class ReportRegister {
    int reportNumber;

    String reporterId;
    String reporterName;
    String reporterPhone;

    String checkRule;               //확인 방법(drop down)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date checkDt;      //신고인 확인 일시

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date checkRegDt;   //매물등록일

    String platform;            //중개플랫폼 업체
    String dealType;                //거래형태
    String intermediary;                //중개대상물 종류

    String reason;              //신고 사유
    String sellNumber;          //매물 번호
    String sourceUrl;                 //출처
    String adress;              //매물 소재지

    String reportedClass;       //피신고대상자 구분
    String reportedName;        //피신고대상자 상호
    String reportedPhone;       //피신고대상자 휴대폰번호
    String reportedAdress;      //피신고 대상자 소재지

    String reportContents;      //신고내용

    //파일 저장
    String filename;
    String urlFilename;
}

