package com.example.fastlms_project.notice.repository;

import com.example.fastlms_project.member.entity.Member;
import com.example.fastlms_project.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, String> {
}
