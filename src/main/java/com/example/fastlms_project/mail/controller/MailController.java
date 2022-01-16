package com.example.fastlms_project.mail.controller;

import com.example.fastlms_project.mail.dto.MailDto;
import com.example.fastlms_project.mail.model.MailParam;
import com.example.fastlms_project.mail.model.MailRegister;
import com.example.fastlms_project.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import util.BaseController;

import java.util.List;

@RequiredArgsConstructor
@Controller

public class MailController extends BaseController {

    private final MailService mailService;

    @GetMapping("/admin/mail/list.do")
    public String list(Model model, MailParam parameter){

        parameter.init();
        List<MailDto> mailDtoList = mailService.list(parameter);

        long totalCount = 0;
        if(!CollectionUtils.isEmpty(mailDtoList)){
            totalCount = mailDtoList.get(0).getTotalCount();
        }

        String queryString = parameter.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

        model.addAttribute("list", mailDtoList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

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
