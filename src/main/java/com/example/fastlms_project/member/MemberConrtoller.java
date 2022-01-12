package com.example.fastlms_project.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberConrtoller {

    @RequestMapping("/member/login")
    public String login(){
        return "/member/login";
    }
}
