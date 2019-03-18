package com.yusufcancelik.demo.Controllers.HR;

import com.yusufcancelik.demo.Models.Job;
import com.yusufcancelik.demo.Services.Concrete.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@PreAuthorize("hasRole('ROLE_HR')")
public class JobController {

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
        return "HR/list";
    }

    @GetMapping("/createjob")
    public String jobCreatePage(Model model) {
        Job job = new Job();
        job.setLastApplicationDate(new Date());
        model.addAttribute("job", job);
        return "HR/create";
    }

    @PostMapping("/createjob")
    public String jobCreatePost(@Valid @ModelAttribute Job job, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("job", job);
            return "HR/create";
        }
        jobService.Save(job);
        return "redirect:/joblist";
    }

    @PostMapping("/deletejob/{id}")
    public String jobDelete(@PathVariable Long id) {
        Job job = jobService.findById(id);
        jobService.Delete(job);
        return "redirect:/joblist";
    }
}
