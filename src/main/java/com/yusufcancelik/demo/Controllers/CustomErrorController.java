package com.yusufcancelik.demo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class CustomErrorController implements ErrorController {
private Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    @GetMapping(value = "/error")
    public String handleError(HttpServletRequest request) {
        Optional<?> status = Optional.ofNullable(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        if (status.isPresent()) {
            int statusCode = Integer.parseInt(status.get().toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }

            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}