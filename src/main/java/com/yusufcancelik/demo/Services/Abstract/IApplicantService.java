package com.yusufcancelik.demo.Services.Abstract;

import com.yusufcancelik.demo.DTO.ApplicantDTO;
import com.yusufcancelik.demo.Models.Applicant;
import org.springframework.data.domain.Page;

public interface IApplicantService {

    Page<Applicant> findAll(int page);

    Applicant findById(Long id);

    Applicant Create(ApplicantDTO applicantDTO);

    Applicant Update(Applicant applicant,Applicant updatedApplicant);

    void Delete(Applicant applicant);

}
