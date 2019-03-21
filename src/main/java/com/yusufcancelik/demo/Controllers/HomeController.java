package com.yusufcancelik.demo.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/login")
    public String loginPage(Authentication authentication){
        return authentication == null ? "login" : "redirect:/joblist";
    }
}
