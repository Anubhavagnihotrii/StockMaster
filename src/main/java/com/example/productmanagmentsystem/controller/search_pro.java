package com.example.productmanagmentsystem.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class search_pro {
    @GetMapping("search-pro")
    public  String search_products()
    {
        log.info("inside the search page");
        return "search-pro";
    }


}
