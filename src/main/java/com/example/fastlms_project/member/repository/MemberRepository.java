package com.example.fastlms_project.member.repository;

import com.example.fastlms_project.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
