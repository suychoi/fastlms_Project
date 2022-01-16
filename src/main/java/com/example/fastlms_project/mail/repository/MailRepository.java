package com.example.fastlms_project.mail.repository;

import com.example.fastlms_project.mail.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, String> {
}
