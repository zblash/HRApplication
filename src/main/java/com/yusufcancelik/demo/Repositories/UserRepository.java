package com.yusufcancelik.demo.Repositories;

import com.yusufcancelik.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
