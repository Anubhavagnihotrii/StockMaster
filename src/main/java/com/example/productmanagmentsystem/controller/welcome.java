package com.example.productmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class welcome {
    @GetMapping("welcome")
    public String welcomePage()
    {
        System.out.println("inside the welcome page");
        return "welcome";
    }
}
