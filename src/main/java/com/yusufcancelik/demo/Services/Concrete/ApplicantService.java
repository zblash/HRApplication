package com.yusufcancelik.demo.Services.Concrete;

import com.yusufcancelik.demo.Models.Applicant;
import com.yusufcancelik.demo.Repositories.ApplicantRepository;
import com.yusufcancelik.demo.Services.Abstract.IApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService implements IApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Page<Applicant> findAll(int page) {
        return applicantRepository.findAll(PageRequest.of(page,10));
    }

    @Override
    public Applicant findById(Long id) {
        return applicantRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Applicant Create(Applicant applicant) {
        return null;
    }

    @Override
    public Applicant Update(Applicant applicant, Applicant updatedApplicant) {
        return null;
    }

    @Override
    public void Delete(Applicant applicant) {

    }
}
