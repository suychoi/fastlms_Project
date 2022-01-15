package com.example.fastlms_project.component.controller;

import com.example.fastlms_project.component.model.MailRegister;
import com.example.fastlms_project.component.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MailController {

    private final MailService mailService;

    @GetMapping("/admin/mail/list.do")
    public String list(){
        return "/admin/mail/list";
    }

    @GetMapping("/admin/mail/register.do")
    public String register(){
        return "/admin/mail/register";
    }

    @PostMapping("/admin/mail/register.do")
    public String register(Model model, MailRegister parameter){

        boolean result = mailService.register(parameter);
        model.addAttribute("result", result);

        return "/admin/mail/register-complete";
    }
}
