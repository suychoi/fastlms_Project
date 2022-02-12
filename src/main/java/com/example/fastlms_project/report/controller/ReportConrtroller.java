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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import util.pager.BaseController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ReportConrtroller extends BaseController {

    private final MemberService memberService;
    private final ReportService reportService;

    @RequestMapping("/report/list")
    public String list(Principal principal, Model model, ReportParam reportParam){

        String userEmail = principal.getName();

        List<ReportDto> reportDtoList = reportService.list(userEmail);

        model.addAttribute("list", reportDtoList);

        return "/report/list";
    }

    @GetMapping("/report/register")
    public String register(Principal principal, Model model){

        String userEmail = principal.getName();

        MemberDto member = memberService.reportMemberInfo(userEmail);

        model.addAttribute("member", member);
        model.addAttribute("userInfo", userEmail);

        return "/report/register";
    }

    @PostMapping("/report/register")
    public String register(Model model, ReportRegister reportRegister, MultipartFile file){


        String saveFilename = "";
        String urlFilename = "";

        if (file != null) {
            String originalFilename = file.getOriginalFilename();

            String baseLocalPath = "C:\\Users\\jack9\\IdeaProjects\\fastlms_Project\\files";
            String baseUrlPath = "/files";

            String[] arrFilename = getNewSaveFile(baseLocalPath, baseUrlPath, originalFilename);

            saveFilename = arrFilename[0];
            urlFilename = arrFilename[1];

            try {
                File newFile = new File(saveFilename);
                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(newFile));
            } catch (IOException e) {
                log.info("############################ - 1");
                log.info(e.getMessage());
            }
        }

        reportRegister.setFilename(saveFilename);
        reportRegister.setUrlFilename(urlFilename);

        boolean result = reportService.reportRegister(reportRegister);
        model.addAttribute("result", result);

        return "/report/register-complete";
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
