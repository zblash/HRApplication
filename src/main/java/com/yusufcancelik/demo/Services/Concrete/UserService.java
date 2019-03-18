package com.yusufcancelik.demo.Services.Concrete;

import com.yusufcancelik.demo.Models.User;
import com.yusufcancelik.demo.Repositories.UserRepository;
import com.yusufcancelik.demo.Services.Abstract.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public User Create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User Update(User user, User updatedUser) {
        return null;
    }

    @Override
    public void Delete(User user) {

    }
}
