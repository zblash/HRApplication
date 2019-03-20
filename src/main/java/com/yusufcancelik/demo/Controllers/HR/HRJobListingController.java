package com.yusufcancelik.demo.Controllers.HR;

import com.yusufcancelik.demo.Models.Job;
import com.yusufcancelik.demo.Services.Concrete.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/hr/job")
@PreAuthorize("hasRole('ROLE_HR')")
public class HRJobListingController {

    @Autowired
    private JobService jobService;

    private Logger logger = LoggerFactory.getLogger(HRJobListingController.class);

    @GetMapping("/create")
    public String jobCreatePage(Model model) {
        Job job = new Job();
        job.setLastApplicationDate(new Date());
        model.addAttribute("job", job);
        return "HR/JobListing/create";
    }

    @PostMapping("/create")
    public String jobCreatePost(@Valid @ModelAttribute Job job, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("job", job);
            return "HR/JobListing/create";
        }

        logger.info(String.valueOf(job.getLastApplicationDate()));
        jobService.Save(job);
        return "redirect:/joblist";
    }

    @PostMapping("/delete/{id}")
    public String jobDelete(@PathVariable Long id) {
        Job job = jobService.findById(id);
        jobService.Delete(job);
        return "redirect:/joblist";
    }
}
