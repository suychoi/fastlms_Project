package com.example.fastlms_project.report.mapper;

import com.example.fastlms_project.report.dto.ReportDto;
import com.example.fastlms_project.report.model.ReportParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    //회원 신고목록
    List<ReportDto> selectList(String userEmail);

    //전체 신고목록 수
    long selectReportCount(ReportParam reportParam);

    //전체 신고목록
    List<ReportDto> selectReportList(ReportParam reportParam);
}
