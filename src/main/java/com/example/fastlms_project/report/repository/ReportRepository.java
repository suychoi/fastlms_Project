package com.example.fastlms_project.report.repository;

import com.example.fastlms_project.report.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}
