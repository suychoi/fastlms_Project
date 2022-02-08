package com.example.fastlms_project.admin.notice.repository;

import com.example.fastlms_project.admin.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
