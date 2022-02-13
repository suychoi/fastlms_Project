package com.example.fastlms_project.report.service;

import com.example.fastlms_project.report.dto.ReportDto;
import com.example.fastlms_project.report.entity.Report;
import com.example.fastlms_project.report.mapper.ReportMapper;
import com.example.fastlms_project.report.model.ReportManage;
import com.example.fastlms_project.report.model.ReportParam;
import com.example.fastlms_project.report.model.ReportRegister;
import com.example.fastlms_project.report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Override
    public boolean reportRegister(ReportRegister parameter) {
        Optional<Report> optionalReport = reportRepository.findById(parameter.getReportNumber());
        if(optionalReport.isPresent()){
            return false;
        }

        Report report = Report.builder()
                .reportNumber(parameter.getReportNumber())
                .reporterId(parameter.getReporterId())
                .reporterName(parameter.getReporterName())
                .reporterPhone(parameter.getReporterPhone())
                .checkRule(parameter.getCheckRule())
                .checkDt(parameter.getCheckDt())
                .checkRegDt(parameter.getCheckRegDt())
                .platform(parameter.getPlatform())
                .dealType(parameter.getDealType())
                .intermediary(parameter.getIntermediary())
                .reason(parameter.getReason())
                .sellNumber(parameter.getSellNumber())
                .sourceUrl(parameter.getSourceUrl())
                .adress(parameter.getAdress())
                .reportedClass(parameter.getReportedClass())
                .reportedName(parameter.getReportedName())
                .reportedPhone(parameter.getReportedPhone())
                .reportedAdress(parameter.getReportedAdress())
                .reportContents(parameter.getReportContents())
                .filename(parameter.getFilename())
                .urlFilename(parameter.getUrlFilename())
                .reportDate(LocalDateTime.now())
                .reportState("-")
                .monitoringRule("-")
                .adUser("-")
                .resultContents("-")
                .resultFile("-")
                .resultFileUrl("-")
                .build();

        reportRepository.save(report);

        return true;
    }

    @Override
    public List<ReportDto> list(String userEmail) {

        List<ReportDto> list = reportMapper.selectList(userEmail);

        return list;
    }

    @Override
    public ReportDto reportDetail(int id) {
        return reportRepository.findById(id).map(ReportDto::of).orElse(null);
    }

    @Override
    public List<ReportDto> allReportList(ReportParam reportParam) {
        long totalCount = reportMapper.selectReportCount(reportParam);

        List<ReportDto> list = reportMapper.selectReportList(reportParam);
        if (!CollectionUtils.isEmpty(list)){
            int i = 0;
            for (ReportDto x : list){
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - reportParam.getPageStart() - i);
                i++;
            }
        }

        return list;
    }

    @Override
    public boolean reportManage(ReportManage parameter) {
        Optional<Report> optionalReport = reportRepository.findById(parameter.getReportNumber());
        if (!optionalReport.isPresent()) {
            return false;
        }
        String stat = parameter.getReportState();

        Report report = optionalReport.get();
        report.setAdUser(parameter.getAdUser());
        report.setMonitoringRule(parameter.getMonitoringRule());
        report.setResultContents(parameter.getResultContents());
        report.setAdDate(LocalDateTime.now());
        report.setReportState(stat);

        if(stat == "진행 전"){
            report.setViewDate(LocalDateTime.now());
        } else if (stat == "조사 중"){
            report.setStartDate(LocalDateTime.now());
        } else if (stat == "처리완료"){
            report.setDoneDate(LocalDateTime.now());
        }

        reportRepository.save(report);

        return true;
    }

}
