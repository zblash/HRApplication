package com.yusufcancelik.demo.Services.Abstract;

import com.yusufcancelik.demo.Models.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findById(Long id);

    User findByEmail(String email);

    User Create(User user);

    User Update(User user,User updatedUser);

    void Delete(User user);
}
