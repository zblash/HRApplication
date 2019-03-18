package com.yusufcancelik.demo.Services.Abstract;

import com.yusufcancelik.demo.Models.Job;
import org.springframework.data.domain.Page;

public interface IJobService {

    Page<Job> findAll(int page);

    Job findById(Long id);

    Job Save(Job job);

    void Delete(Job job);
}
