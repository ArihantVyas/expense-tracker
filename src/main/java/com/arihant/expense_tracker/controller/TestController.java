package com.arihant.expense_tracker.controller;

import com.arihant.expense_tracker.config.ServerPortLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private ServerPortLogger logger;

    @GetMapping("/test")
    public String testMethod(){
        return "App running on port : "+logger.getPort();
    }
}
