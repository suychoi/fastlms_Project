package com.example.fastlms_project.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberConrtoller {

    @RequestMapping("/member/login")
    public String login(){
        return "/member/login";
    }

    @GetMapping("/member/register")
    public String register(){
        return "/member/register";
    }

    @PostMapping("/member/register")
    public String register(HttpServletRequest request){
        return "/member/register";
    }
}
