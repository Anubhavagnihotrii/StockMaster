package com.example.productmanagmentsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class Home {
    @GetMapping("go_home")
    public String HomePage()
    {
        log.info("Inside Index Controller Page");
        return "index";
    }
}
