package com.example.fastlms_project.report.service;

import com.example.fastlms_project.report.dto.ReportDto;
import com.example.fastlms_project.report.entity.Report;
import com.example.fastlms_project.report.mapper.ReportMapper;
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
                .reportState("미정")
                .monitoringRule("미정")
                .build();

        reportRepository.save(report);

        return true;
    }

    @Override
    public boolean reportEdit(ReportRegister parameter) {
        return false;
    }

    @Override
    public ReportDto reportGetDetail(int key) {
        return null;
    }

    @Override
    public List<ReportDto> list(String userEmail) {

        List<ReportDto> list = reportMapper.selectList(userEmail);

        return list;
    }

    @Override
    public List<ReportDto> reportDetail(ReportParam param) {
        return null;
    }

    @Override
    public boolean reportDelete(Integer deleteId) {
        return false;
    }
}
