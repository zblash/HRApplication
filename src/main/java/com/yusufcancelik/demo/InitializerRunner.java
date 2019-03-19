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
        user.setEmail("yusufcancelik@hotmail.com");
        user.setName("Yusuf Can Celik");
        user.setPassword("zxczxc");

        Role role = new Role();
        role.setName("ROLE_HR");

        roleService.Create(role);

        user.setRole(role);
        userService.Create(user);
    }
}
