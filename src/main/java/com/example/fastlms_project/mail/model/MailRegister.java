package com.example.fastlms_project.mail.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class MailRegister {
    private String mailKey;
    private String mailTitle;
    private String mailContents;
}
