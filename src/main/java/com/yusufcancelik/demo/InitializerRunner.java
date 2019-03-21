package com.yusufcancelik.demo;

import com.yusufcancelik.demo.Models.Role;
import com.yusufcancelik.demo.Models.User;
import com.yusufcancelik.demo.Services.Concrete.RoleService;
import com.yusufcancelik.demo.Services.Concrete.StorageService;
import com.yusufcancelik.demo.Services.Concrete.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializerRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private StorageService storageService;

    @Override
    public void run(String... args) throws Exception {
        storageService.init();

        User user = new User();
        user.setEmail("hrmanager@hrapplication.com");
        user.setName("Yusuf Can Celik");
        user.setPassword("hrmanager");

        User user2 = new User();
        user2.setEmail("normaluser@hrapplication.com");
        user2.setName("Yusuf Can Celik");
        user2.setPassword("normaluser");

        Role role = new Role();
        role.setName("ROLE_HR");

        Role role2 = new Role();
        role2.setName("ROLE_User");

        roleService.Create(role);
        roleService.Create(role2);

        user.setRole(role);
        user2.setRole(role2);
        userService.Create(user);
        userService.Create(user2);
    }
}
