package com.example.fastlms_project.member.controller;

import com.example.fastlms_project.member.model.MemberRegister;
import com.example.fastlms_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class MemberConrtoller {

    private final MemberService memberService;

    @RequestMapping("/member/login")
    public String login(){
        return "/member/login";
    }

    @GetMapping("/member/register")
    public String register(){
        return "/member/register";
    }

    @PostMapping("/member/register")
    public String register(Model model, MemberRegister parameter){

        boolean result = memberService.register(parameter);
        model.addAttribute("result", result);

        return "/member/register-complete";
    }

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model, HttpServletRequest request){

        String uuid = request.getParameter("id");
        boolean result = memberService.emailAuth(uuid);

        model.addAttribute("result", result);

        return "/member/email_Auth";
    }}
