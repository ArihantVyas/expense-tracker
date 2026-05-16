package com.arihant.expense_tracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 15, message = "Username size must be in range 3 to 15")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 128, message = "Password size must be in range 8 to 128")
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email
    @Size(max = 255, message = "Length of email cannot be more than 255 characters")
    private String email;

    public UserRegisterDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
