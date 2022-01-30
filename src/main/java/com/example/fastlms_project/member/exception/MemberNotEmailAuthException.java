package com.example.fastlms_project.member.exception;

public class MemberNotEmailAuthException extends RuntimeException{
    public MemberNotEmailAuthException(String error){
        super(error);
    }
}
