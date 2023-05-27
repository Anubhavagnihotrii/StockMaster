package com.example.productmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class login {
    @GetMapping("/login")
    public String login()
    {
        System.out.println("Inside the Login Page");
        return "login";
    }
}
