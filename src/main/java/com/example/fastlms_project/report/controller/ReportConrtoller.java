package com.example.fastlms_project.report.controller;

import com.example.fastlms_project.member.model.MemberRegister;
import com.example.fastlms_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class ReportConrtoller {
    
    @RequestMapping("/report/list")
    public String list(){
        return "/report/list";
    }

}
