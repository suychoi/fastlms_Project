package com.example.fastlms_project.component.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Mail {
    @Id
    private String mailKey;

    private String mailTitle;
    private String mailContents;
}
