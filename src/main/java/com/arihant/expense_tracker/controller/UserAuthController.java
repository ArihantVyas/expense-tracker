package com.arihant.expense_tracker.controller;

import com.arihant.expense_tracker.dto.UserRegisterDto;
import com.arihant.expense_tracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAuthController {

    private UserService userService;

    public UserAuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String createNewUser(@RequestBody @Valid UserRegisterDto registerDto){

        return userService.registerUser(registerDto);
    }


}
