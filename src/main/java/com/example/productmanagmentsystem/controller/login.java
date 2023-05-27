package com.example.productmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class login {
    @GetMapping("/login")
    public String login()
    {
        System.out.println("Inside the Login Page");
        return "login";
    }
    @PostMapping("/login")
    public String login_val(@RequestParam("username") String username , @RequestParam("password") String password)
    {
        System.out.println("Inside the login form click");

        if(username.equals("anubhav") && password.equals("agnihotri"))
        {
            return "/welcome";
        }
        else
        {
            return "/login";
        }

    }
}
