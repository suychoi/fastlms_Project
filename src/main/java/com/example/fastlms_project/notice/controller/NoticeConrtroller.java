package com.example.fastlms_project.notice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class NoticeConrtroller {
    
    @RequestMapping("/notice/list")
    public String list(){
        return "/notice/list";
    }

}
