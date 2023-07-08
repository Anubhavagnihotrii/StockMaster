package com.example.productmanagmentsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class display {
    @GetMapping("Display_File")
    public String displayFile(Model model) {
        log.info("inside display file page");

        List<String> fileContents = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                fileContents.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("fileContents", fileContents);

        // String content =fileContents.toString();
        // log.info(content);
        return "displayFile";
    }
}
