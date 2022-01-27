package com.example.fastlms_project.exception.advice;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResult {
    private String code;
    private String message;
}
