package com.example.fastlms_project.notice.controller;

import com.example.fastlms_project.notice.dto.NoticeDto;
import com.example.fastlms_project.notice.model.NoticeParam;
import com.example.fastlms_project.notice.service.MainNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import util.pager.BaseController;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainNoticeConrtroller extends BaseController {

    private final MainNoticeService mainNoticeService;

    @RequestMapping("/mainNotice/noticeList")
    public String list(Model model, NoticeParam parameter){

        parameter.init();
        List<NoticeDto> NoticeDto = mainNoticeService.mainNoticeList(parameter);

        long totalCount = 0;
        if(!CollectionUtils.isEmpty(NoticeDto)){
            totalCount = NoticeDto.get(0).getTotalCount();
        }

        String queryString = parameter.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

        model.addAttribute("list", NoticeDto);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "/mainNotice/noticeList";
    }

    @GetMapping("/mainNotice/view.do")
    public String view(Model model, NoticeParam parameter){

        NoticeDto mainNotice = mainNoticeService.mainNoticeDetail(parameter.getNoticeNumber());
        if(mainNotice == null){
            model.addAttribute("message", "공지사항 정보가 없습니다.");
            return "error/error";
        }
        model.addAttribute("mainNotice", mainNotice);

        return "/mainNotice/noticeView";
    }

}
