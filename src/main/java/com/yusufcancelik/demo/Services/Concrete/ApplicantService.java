package com.yusufcancelik.demo.Services.Concrete;

import com.yusufcancelik.demo.DTO.ApplicantDTO;
import com.yusufcancelik.demo.Models.Applicant;
import com.yusufcancelik.demo.Repositories.ApplicantRepository;
import com.yusufcancelik.demo.Repositories.JobRepository;
import com.yusufcancelik.demo.Services.Abstract.IApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ApplicantService implements IApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Page<Applicant> findAll(int page) {
        return applicantRepository.findAllByOrderByIdDesc(PageRequest.of(page,10));
    }

    @Override
    public Applicant findById(Long id) {
        return applicantRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Applicant Create(ApplicantDTO applicantDTO) {
        Applicant applicant = new Applicant();
        applicant.setEmail(applicantDTO.getEmail());
        applicant.setName(applicantDTO.getName());
        applicant.setAddress(applicantDTO.getAddress());
        applicant.setPhone(applicantDTO.getPhone());
        applicant.setThoughts(applicantDTO.getThoughts());
        applicant.setJob(jobRepository.findById(applicantDTO.getJobId()).orElseThrow(RuntimeException::new));

        SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
        String formattedDate = df.format(new Date());
        try {
            applicant.setApplicationDate(df.parse(formattedDate));
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        String fileName = storageService.store(applicantDTO.getFile(),applicantDTO.getName());
        applicant.setResumeLink(fileName);

        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant Update(Applicant applicant, Applicant updatedApplicant) {
        return null;
    }

    @Override
    public void Delete(Applicant applicant) {

    }
}
