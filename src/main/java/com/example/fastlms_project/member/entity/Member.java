package com.example.fastlms_project.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Member {
    @Id
    private String userEmail;

    private String userName;
    private String password;
    private String userPhone;
    private LocalDateTime regDt;

    private boolean adminRoleYn;

    private boolean emailAuthYn;
    private LocalDateTime emailAuthDt;
    private String emailAuthKey;
}
