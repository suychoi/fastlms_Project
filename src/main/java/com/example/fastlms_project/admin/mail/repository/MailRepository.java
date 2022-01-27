package com.example.fastlms_project.admin.mail.repository;

import com.example.fastlms_project.admin.mail.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MailRepository extends JpaRepository<Mail, String> {
    @Override
    Optional<Mail> findById(String s);
}
