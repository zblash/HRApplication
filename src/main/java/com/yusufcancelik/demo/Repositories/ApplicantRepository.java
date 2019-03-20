package com.yusufcancelik.demo.Repositories;

import com.yusufcancelik.demo.Models.Applicant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

    Page<Applicant> findAllByOrderByIdDesc(Pageable var1);

}
