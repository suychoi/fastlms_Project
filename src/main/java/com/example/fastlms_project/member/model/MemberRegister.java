package com.example.fastlms_project.member.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class MemberRegister {
    private String userEmail;
    private String userName;
    private String password;
    private String userPhone;
}
