package com.example.productmanagmentsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping(value = "welcome",method = RequestMethod.GET)
public class welcome {

    public String welcome()
    {
        System.out.println("Inside the Welcome Page");
        return "welcome";
    }
}
