package com.example.productmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class login {
    @GetMapping("/login")
    public String dologin()
    {
        System.out.println("Inside the Login Page");
        return "login";
    }
    @PostMapping("login")
    public String login_val(@RequestParam("username") String username , @RequestParam("password") String password, Model model)
    {
        System.out.println("Inside the login form click");

        String u1="anubhav";
        String p1="agnihotri";
        String u2="himanshu";
        String p2="prasad";
        String u3="admin";
        String p3="pass";

        if(username.equals(u1) && password.equals(p1) || username.equals(u2) && password.equals(p2) || username.equals(u3) && password.equals(p3))
        {
            System.out.println("inside the welcome page");
            model.addAttribute("success","Logged in Sucessfully !");
            model.addAttribute("logedin","Welcome"+username);
            return "/welcome";

        }
        else
        {
            model.addAttribute("failure","Log in Failed please try again");
            return "/login";

        }

    }
}
