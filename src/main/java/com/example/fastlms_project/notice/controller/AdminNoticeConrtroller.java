package com.example.fastlms_project.notice.controller;

import com.example.fastlms_project.notice.dto.NoticeDto;
import com.example.fastlms_project.notice.model.NoticeParam;
import com.example.fastlms_project.notice.model.NoticeRegister;
import com.example.fastlms_project.notice.service.AdminNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import util.pager.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminNoticeConrtroller extends BaseController {

    private final AdminNoticeService adminNoticeService;

    @RequestMapping("/admin/notice/list.do")
    public String list(Model model, NoticeParam parameter){

        parameter.init();
        List<NoticeDto> NoticeDto = adminNoticeService.noticeList(parameter);

        long totalCount = 0;
        if(!CollectionUtils.isEmpty(NoticeDto)){
            totalCount = NoticeDto.get(0).getTotalCount();
        }

        String queryString = parameter.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

        model.addAttribute("list", NoticeDto);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "/admin/notice/list";
    }

    @GetMapping(value = {"/admin/notice/register.do", "/admin/notice/edit.do"})
    public String register(Model model, HttpServletRequest request, NoticeRegister parameter){

        boolean editMode = request.getRequestURI().contains("/edit.do");
        NoticeDto noticeDetail = new NoticeDto();

        if (editMode) {
            int key = parameter.getNoticeNumber();
            NoticeDto existNotice = adminNoticeService.noticeGetDetail(key);
            if(existNotice == null){
                //나중에 에러처리 만들어야 함
                model.addAttribute("message", "공지사항 정보가 없습니다.");
                return "error/error";
            }
            noticeDetail = existNotice;
        }

        model.addAttribute("editMode", editMode);
        model.addAttribute("noticeDetail", noticeDetail);

        return "/admin/notice/register";
    }

    @PostMapping(value = {"/admin/notice/register.do", "/admin/notice/edit.do"})
    public String mailRegister(Model model, HttpServletRequest request, NoticeRegister parameter){

        boolean editMode = request.getRequestURI().contains("/edit.do");

        if(editMode){
            Integer key = parameter.getNoticeNumber();
            NoticeDto existNotice = adminNoticeService.noticeGetDetail(key);
            if (existNotice == null){
                model.addAttribute("message", "공지사항이 존재하지 않습니다.");
                return "error/error";
            }

            boolean result = adminNoticeService.noticeEdit(parameter);
            model.addAttribute("result", result);
            return "/admin/notice/register-complete";

        } else {

            boolean result = adminNoticeService.noticeRegister(parameter);
            model.addAttribute("result", result);
            return "/admin/notice/register-complete";
        }
    }

    @GetMapping("/admin/notice/delete.do")
    public String deleteMail(Model model, NoticeRegister parameter){

        boolean result = adminNoticeService.noticeDelete(parameter.getNoticeNumber());
        model.addAttribute("result", result);

        return "/admin/notice/list";
    }
}
