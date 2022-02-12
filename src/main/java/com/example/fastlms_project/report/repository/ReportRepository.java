package com.example.fastlms_project.report.repository;

import com.example.fastlms_project.report.entity.Report;
import com.example.fastlms_project.report.model.ReportParam;
import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {

}
