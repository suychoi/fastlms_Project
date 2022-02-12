package com.example.fastlms_project.report.mapper;

import com.example.fastlms_project.report.dto.ReportDto;
import com.example.fastlms_project.report.model.ReportParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    
    long selectReportCount(String userEmail);
    List<ReportDto> selectList(String userEmail);
    
}
