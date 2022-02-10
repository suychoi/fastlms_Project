package com.example.fastlms_project.report.dto;

import com.example.fastlms_project.report.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReportDto {
    String reportNumber;

    String reporterId;
    String reporterName;
    String reporterPhone;

    String reason;    //신고 사유
    String check;     //확인 방법(drop down)
    String url;       //출처
    String sellNumber;    //매물 번호
    String adress;    //매물 소재지

    LocalDateTime reportDate;       //등록일자
    String reportState;
    String monitoringRule;      //모니터링 방법법
    LocalDateTime viewDate;     //확인 일자
    LocalDateTime startDate;    //조사 일자
    LocalDateTime doneDate;     //종료 일자


    String reportedClass;    //피신고대상자 구분
    String reportedName;     //피신고대상자 상호
    String reportedPhone;   //피신고대상자 휴대폰번호
    String reportedAdress;  //피신고 대상자 소재지

    String reportContents;  //신고내용
    String reportFile;

    long totalCount;
    long seq;

    public static ReportDto of(Report report){
        return ReportDto.builder()
                .reportNumber(report.getReportNumber())
                .reportState(report.getReportState())
                .monitoringRule(report.getMonitoringRule())
                .reportDate(report.getReportDate())
                .viewDate(report.getViewDate())
                .startDate(report.getStartDate())
                .doneDate(report.getDoneDate())
                .reporterId(report.getReporterId())
                .reporterName(report.getReporterName())
                .reporterPhone(report.getReporterPhone())
                .reason(report.getReason())
                .check(report.getCheck())
                .url(report.getUrl())
                .sellNumber(report.getSellNumber())
                .adress(report.getAdress())
                .reportedClass(report.getReportedClass())
                .reportedName(report.getReportedName())
                .reportedPhone(report.getReportedPhone())
                .reportedAdress(report.getReportedAdress())
                .reportContents(report.getReportContents())
                .reportFile(report.getReportFile())
                .build();
    }

    public static List<ReportDto> of(List<Report> reportList){
        if (reportList == null){
            return null;
        }

    List<ReportDto> reportDtoList = new ArrayList<>();
        for(Report x : reportList){
            reportDtoList.add(ReportDto.of(x));
        }
    return reportDtoList;
    }
}
