package com.example.fastlms_project.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    NO_EMAIL_AUTH(HttpStatus.valueOf(404), "이메일 인증이 필요합니다."),
    NO_EMAIL_KEY(HttpStatus.valueOf(500), "존재하지 않는 이메일 KEY 입니다.")
    ;



    private final HttpStatus status;
    private final String message;
}
