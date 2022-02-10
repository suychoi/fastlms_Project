package com.example.fastlms_project.report.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class ReportConrtroller {
    
    @RequestMapping("/report/list")
    public String list(Principal principal, Model model){

        model.addAttribute("userInfo", principal.getName());

        return "/report/list";
    }

    @GetMapping("/report/register")
    public String register(Principal principal, Model model){
        model.addAttribute("userInfo", principal.getName());
        return "/report/register";
    }
}
