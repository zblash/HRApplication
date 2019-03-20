package com.yusufcancelik.demo.Services.Concrete;

import com.yusufcancelik.demo.Models.Job;
import com.yusufcancelik.demo.Repositories.JobRepository;
import com.yusufcancelik.demo.Services.Abstract.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class JobService implements IJobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Page<Job> findAll(int page) {
        return jobRepository.findAllByOrderByIdDesc(PageRequest.of(page,10));
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Job Save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void Delete(Job job) {
        jobRepository.delete(job);
    }
}
