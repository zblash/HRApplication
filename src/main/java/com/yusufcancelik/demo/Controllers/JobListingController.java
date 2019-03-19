package com.yusufcancelik.demo.Controllers;

import com.yusufcancelik.demo.DTO.ApplicantDTO;
import com.yusufcancelik.demo.Models.Applicant;
import com.yusufcancelik.demo.Models.Job;
import com.yusufcancelik.demo.Services.Concrete.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class JobListingController {

    @Autowired
    private JobService jobService;

    @GetMapping("/joblist")
    public String jobListPage(@RequestParam(required = false) Integer page, Model model) {
        int pageNumber = Optional.ofNullable(page).orElse(1);
        Page<Job> jobs = jobService.findAll(pageNumber - 1);
        model.addAttribute("jobs", jobs);
        int totalPages = jobs.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "jobListingList";
    }


    @GetMapping("/job/detail/{id}")
    public String jobDetailPage(@PathVariable Long id, Model model){
        model.addAttribute("applicant",new ApplicantDTO());
        model.addAttribute("job",jobService.findById(id));
        return "jobListingDetail";
    }
}
