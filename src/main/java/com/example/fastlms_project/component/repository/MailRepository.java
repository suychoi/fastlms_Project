package com.example.fastlms_project.component.repository;

import com.example.fastlms_project.component.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, String> {
}
