package com.example.fastlms_project.notice.repository;

import com.example.fastlms_project.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
