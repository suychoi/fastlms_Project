package com.example.fastlms_project.report.service;

import com.example.fastlms_project.report.dto.ReportDto;
import com.example.fastlms_project.report.model.ReportParam;
import com.example.fastlms_project.report.model.ReportRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {


    @Override
    public boolean ReportRegister(ReportRegister parameter) {
        return false;
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
    public List<ReportDto> reportList(ReportParam param) {
        return null;
    }

    @Override
    public boolean reportDelete(Integer deleteId) {
        return false;
    }
}
