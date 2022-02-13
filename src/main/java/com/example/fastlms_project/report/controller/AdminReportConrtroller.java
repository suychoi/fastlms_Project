package com.example.fastlms_project.report.controller;

import com.example.fastlms_project.report.dto.ReportDto;
import com.example.fastlms_project.report.model.ReportManage;
import com.example.fastlms_project.report.model.ReportParam;
import com.example.fastlms_project.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import util.pager.BaseController;

import java.security.Principal;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminReportConrtroller extends BaseController {

    private final ReportService reportService;

    @RequestMapping("/admin/report/list.do")
    public String list( Model model, ReportParam reportParam){

        reportParam.init();
        List<ReportDto> ReportDto = reportService.allReportList(reportParam);

        long totalCount = 0;
        if(!CollectionUtils.isEmpty(ReportDto)){
            totalCount = ReportDto.get(0).getTotalCount();
        }

        String queryString = reportParam.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, reportParam.getPageSize(), reportParam.getPageIndex(), queryString);

        model.addAttribute("list", ReportDto);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "/admin/report/list";
    }

    @GetMapping("/admin/report/manage.do")
    public String reportView(Principal principal, Model model, ReportParam reportParam){

        int id = reportParam.getReportNumber();
        ReportDto report = reportService.reportDetail(id);

        model.addAttribute("member", principal.getName());
        model.addAttribute("report", report);

        return "/admin/report/manage";
    }

    @PostMapping("/admin/report/manage.do")
    public String manageReport(Model model, ReportManage reportManage){

        boolean result = reportService.reportManage(reportManage);

        model.addAttribute("result", result);
        return "/admin/report/manage-complete";
    }
}
