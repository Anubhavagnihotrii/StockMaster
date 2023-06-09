package com.example.productmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Home {
    @GetMapping("/Home")
    public String Home()
    {
        System.out.println("Inside Index Controller Page");
        return "index";
    }
}
