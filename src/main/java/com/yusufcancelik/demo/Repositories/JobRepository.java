package com.yusufcancelik.demo.Repositories;

import com.yusufcancelik.demo.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
