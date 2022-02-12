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

    //신고 수정
    boolean reportEdit(ReportRegister parameter);

    //신고 수정 세부내용
    ReportDto reportGetDetail(int key);

    //신고 삭제
    boolean reportDelete(Integer deleteId);

//Admin
}
