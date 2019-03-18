package com.yusufcancelik.demo.Repositories;

import com.yusufcancelik.demo.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
