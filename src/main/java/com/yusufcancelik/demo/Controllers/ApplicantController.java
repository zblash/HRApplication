package com.yusufcancelik.demo.Controllers;

import com.yusufcancelik.demo.DTO.ApplicantDTO;
import com.yusufcancelik.demo.Models.Applicant;
import com.yusufcancelik.demo.Services.Concrete.ApplicantService;
import com.yusufcancelik.demo.Services.Concrete.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private StorageService storageService;

    @PostMapping("/applicant/form")
    @Validated
    public ResponseEntity<?> applicantForm(@Valid @ModelAttribute ApplicantDTO applicantDTO){
        storageService.store(applicantDTO.getFile(),applicantDTO.getName());
        Applicant applicant = applicantService.Create(applicantDTO);
        return ResponseEntity.ok(applicant);
    }

}
