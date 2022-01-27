package com.example.fastlms_project.exception.advice;

import com.example.fastlms_project.exception.Exception;
import com.example.fastlms_project.exception.ExceptionCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResult> runtimeException(Exception e){
        ExceptionCode errorCode = e.getCode();
        ErrorResult result = ErrorResult.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .build();
        return new ResponseEntity(result, errorCode.getStatus());
    }
}
