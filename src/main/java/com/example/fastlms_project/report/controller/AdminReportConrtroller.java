package com.example.fastlms_project.report.controller;

import com.example.fastlms_project.member.service.MemberService;
import com.example.fastlms_project.report.dto.MemberDto;
import com.example.fastlms_project.report.dto.ReportDto;
import com.example.fastlms_project.report.model.ReportParam;
import com.example.fastlms_project.report.model.ReportRegister;
import com.example.fastlms_project.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import util.pager.BaseController;

import java.io.File;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminReportConrtroller extends BaseController {

    private final MemberService memberService;
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

    @GetMapping("/admin/report/register")
    public String register(Principal principal, Model model){

        return "/admin/report/register";
    }

    @PostMapping("/admin/report/register")
    public String register(Model model, ReportRegister reportRegister, MultipartFile file){


        return "/admin/report/register-complete";
    }

    @GetMapping("/admin/report/manage.do")
    public String reportView(Principal principal, Model model, ReportParam reportParam){

        int id = reportParam.getReportNumber();
        ReportDto report = reportService.reportDetail(id);

        model.addAttribute("member", principal.getName());
        model.addAttribute("report", report);

        return "/admin/report/manage";
    }


    private String[] getNewSaveFile(String baseLocalPath, String baseUrlPath, String originalFilename) {

        LocalDate now = LocalDate.now();

        String[] dirs = {
                String.format("%s/%d/", baseLocalPath,now.getYear()),
                String.format("%s/%d/%02d/", baseLocalPath, now.getYear(),now.getMonthValue()),
                String.format("%s/%d/%02d/%02d/", baseLocalPath, now.getYear(), now.getMonthValue(), now.getDayOfMonth())};

        String urlDir = String.format("%s/%d/%02d/%02d/", baseUrlPath, now.getYear(), now.getMonthValue(), now.getDayOfMonth());

        for(String dir : dirs) {
            File file = new File(dir);
            if (!file.isDirectory()) {
                file.mkdir();
            }
        }

        String fileExtension = "";
        if (originalFilename != null) {
            int dotPos = originalFilename.lastIndexOf(".");
            if (dotPos > -1) {
                fileExtension = originalFilename.substring(dotPos + 1);
            }
        }

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String newFilename = String.format("%s%s", dirs[2], uuid);
        String newUrlFilename = String.format("%s%s", urlDir, uuid);
        if (fileExtension.length() > 0) {
            newFilename += "." + fileExtension;
            newUrlFilename += "." + fileExtension;
        }

        return new String[]{newFilename, newUrlFilename};
    }
}
