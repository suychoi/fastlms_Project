package com.example.fastlms_project.report.service;

import com.example.fastlms_project.report.dto.ReportDto;
import com.example.fastlms_project.report.model.ReportParam;
import com.example.fastlms_project.report.model.ReportRegister;

import java.util.List;

public interface ReportService {
//Member
    //신고 등록
    boolean reportRegister(ReportRegister parameter);

    //나의 신고 목록 가져오기
    List<ReportDto> list(String userEmail);

    //신고 상세목록 가져오기
    ReportDto reportDetail(int id);

//Admin
    List<ReportDto> allReportList(ReportParam reportParam);
}
