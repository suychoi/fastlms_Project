package com.example.fastlms_project.report.dto;

import com.example.fastlms_project.report.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReportDto {
    int reportNumber;

    String reporterId;
    String reporterName;
    String reporterPhone;

    String reason;          //신고 사유
    String checkRule;       //확인 방법(drop down)
    String sourceUrl;       //출처
    String sellNumber;      //매물 번호
    String adress;          //매물 소재지

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

    String filename;
    String urlFilename;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date checkDt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date checkRegDt;
    String platform;
    String dealType;
    String intermediary;

    String adUser;            //확인자
    LocalDateTime adDate;            //점검일자
    String resultContents;    //처리결과
    String resultFile;        //첨부파일
    String resultFileUrl;        //첨부파일URL

    long totalCount;
    long seq;

    public static ReportDto of(Report report){
        return ReportDto.builder()
                .reportNumber(report.getReportNumber())
                .adUser(report.getAdUser())
                .adDate(report.getAdDate())
                .resultContents(report.getResultContents())
                .resultFile(report.getResultFile())
                .resultFileUrl(report.getResultFileUrl())
                .checkDt(report.getCheckDt())
                .checkRegDt(report.getCheckRegDt())
                .platform(report.getPlatform())
                .dealType(report.getDealType())
                .intermediary(report.getIntermediary())
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
                .checkRule(report.getCheckRule())
                .sourceUrl(report.getSourceUrl())
                .sellNumber(report.getSellNumber())
                .adress(report.getAdress())
                .reportedClass(report.getReportedClass())
                .reportedName(report.getReportedName())
                .reportedPhone(report.getReportedPhone())
                .reportedAdress(report.getReportedAdress())
                .reportContents(report.getReportContents())
                .filename(report.getFilename())
                .urlFilename(report.getUrlFilename())
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

    public String getReportDateText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return reportDate != null ? reportDate.format(formatter) : "";
    }

    public String getViewDateText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return viewDate != null ? viewDate.format(formatter) : "";
    }

    public String getStartDateText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return startDate != null ? startDate.format(formatter) : "";
    }

    public String getDoneDateText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return doneDate != null ? doneDate.format(formatter) : "";
    }

    public String getAdDateText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return adDate != null ? adDate.format(formatter) : "";
    }
}
