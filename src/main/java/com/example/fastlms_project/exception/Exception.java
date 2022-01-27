package com.example.fastlms_project.exception;

import lombok.Getter;

@Getter
public class Exception extends RuntimeException{
    private final ExceptionCode code;

    public Exception(ExceptionCode code){
        this.code = code;
    }
}
