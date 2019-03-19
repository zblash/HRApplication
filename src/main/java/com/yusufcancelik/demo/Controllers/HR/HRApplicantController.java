package com.yusufcancelik.demo.Controllers.HR;

import com.yusufcancelik.demo.Models.Applicant;
import com.yusufcancelik.demo.Services.Concrete.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/hr/applicant")
@PreAuthorize("hasRole('ROLE_HR')")
public class HRApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/list")
    public String applicantListPage(@RequestParam(required = false) Integer page, Model model) {
        int pageNumber = Optional.ofNullable(page).orElse(1);
        Page<Applicant> applicants = applicantService.findAll(pageNumber - 1);
        model.addAttribute("applicants", applicants);
        int totalPages = applicants.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "/HR/Applicants/list";
    }

    @GetMapping("/detail/{id}")
    public String applicantDetailPage(@PathVariable Long id, Model model){
        Applicant applicant = applicantService.findById(id);
        model.addAttribute("applicant",applicant);
        return "/HR/Applicants/detail";
    }
}
