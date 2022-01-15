package com.example.fastlms_project.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AdminMainConrtoller {

    @GetMapping("/admin/main.do")
    public String main(){
        return "/admin/main";
    }

    @GetMapping("/error/denied.do")
    public String error(){
        return "/error/denied";
    }
}
