package com.example.productmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Home {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String Home(Model model)
    {
        System.out.println("Inside Index Controller Page");
        return "index";
    }
}
