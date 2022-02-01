package com.example.fastlms_project.admin.mail.controller;

import com.example.fastlms_project.admin.mail.dto.MailDto;
import com.example.fastlms_project.admin.mail.model.MailParam;
import com.example.fastlms_project.admin.mail.service.MailService;
import com.example.fastlms_project.admin.mail.model.MailRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import util.pager.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller

public class MailController extends BaseController {

    private final MailService mailService;

    @GetMapping("/admin/mail/list.do")
    public String list(Model model, MailParam parameter){

        parameter.init();
        List<MailDto> mailDtoList = mailService.mailList(parameter);

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

    @GetMapping(value = {"/admin/mail/register.do", "/admin/mail/edit.do"})
    public String register(Model model, HttpServletRequest request, MailRegister parameter){

        boolean editMode = request.getRequestURI().contains("/edit.do");
        MailDto mailDetail = new MailDto();

        if (editMode) {
            String key = parameter.getMailKey();
            MailDto existMail = mailService.mailGetDetail(key);
            if(existMail == null){
                //나중에 에러처리 만들어야 함
                model.addAttribute("message", "메일 정보가 없습니다.");
                return "error/error";
            }
            mailDetail = existMail;
        }

        model.addAttribute("editMode", editMode);
        model.addAttribute("mailDetail", mailDetail);

        return "/admin/mail/register";
    }

    @PostMapping(value = {"/admin/mail/register.do", "/admin/mail/edit.do"})
    public String mailRegister(Model model, HttpServletRequest request, MailRegister parameter){

        boolean editMode = request.getRequestURI().contains("/edit.do");

        if(editMode){
            String key = parameter.getMailKey();
            MailDto existMail = mailService.mailGetDetail(key);
            if (existMail == null){
                model.addAttribute("message", "템플릿 정보가 존재하지 않습니다.");
                return "error/error";
            }

            boolean result = mailService.mailEdit(parameter);
            model.addAttribute("result", result);
            return "/admin/mail/register-complete";

        } else {

            boolean result = mailService.mailRegister(parameter);
            model.addAttribute("result", result);
            return "/admin/mail/register-complete";
        }
    }

    @PostMapping("/admin/mail/delete.do")
    public String deleteMail(MailRegister parameter){

        mailService.mailDelete(parameter.getIdList());

        return "redirect:/admin/mail/list.do";
    }
}
