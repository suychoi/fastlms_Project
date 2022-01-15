package com.example.fastlms_project.component.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class MailRegister {
    private String mailKey;
    private String mailTitle;
    private String mailContents;
}
