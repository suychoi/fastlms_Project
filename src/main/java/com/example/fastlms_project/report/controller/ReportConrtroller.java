package com.example.fastlms_project.report.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class ReportConrtroller {
    
    @RequestMapping("/report/list")
    public String list(){
        return "/report/list";
    }

}
