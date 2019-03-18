package com.yusufcancelik.demo.Repositories;

import com.yusufcancelik.demo.Models.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
}
