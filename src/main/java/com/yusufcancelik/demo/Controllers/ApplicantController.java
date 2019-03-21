package com.yusufcancelik.demo.Controllers;

import com.yusufcancelik.demo.DTO.ApplicantDTO;
import com.yusufcancelik.demo.Models.Applicant;
import com.yusufcancelik.demo.Services.Concrete.ApplicantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    private Logger logger = LoggerFactory.getLogger(ApplicantController.class);

    @PostMapping("/applicant/form")
    public ResponseEntity<?> applicantForm(@Valid @ModelAttribute ApplicantDTO applicantDTO, Errors errors){
        logger.info(String.valueOf(errors.getErrorCount()));
        if (errors.hasErrors()){

            String errorMsg = errors.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining(","));
            return ResponseEntity.badRequest().body(errorMsg);
        }
        Applicant applicant = applicantService.Create(applicantDTO);
        return ResponseEntity.ok().body("Başvurunuz Alındı.");
    }

}
