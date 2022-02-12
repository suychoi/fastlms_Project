package com.example.fastlms_project.report.controller;

import com.example.fastlms_project.member.service.MemberService;
import com.example.fastlms_project.report.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class ReportConrtroller {

    private final MemberService memberService;

    @RequestMapping("/report/list")
    public String list(Principal principal, Model model){

        model.addAttribute("userInfo", principal.getName());

        return "/report/list";
    }

    @GetMapping("/report/register")
    public String register(Principal principal, Model model){

        String userEmail = principal.getName();

        MemberDto member = memberService.reportMemberInfo(userEmail);

        model.addAttribute("member", member);
        model.addAttribute("userInfo", userEmail);

        return "/report/register";
    }
}
