package com.example.productmanagmentsystem.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

@Slf4j
@Controller
public class search_pro {
    @GetMapping("search-pro")
    public  String search_products()
    {
        log.info("inside the search page");
        return "search-pro";
    }
    @PostMapping("search-pro")
    public String search(@RequestParam("product-code")String product_code , @RequestParam("product-name") String product_name, Model model) {
        log.info(product_code);
        log.info(product_name);

        Boolean findd = false;
        String foundLine = null;
        try {
            File file = new File("products.txt");
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(product_code) && line.contains(product_name)) {
//                    log.info("Found: " + line);
                    foundLine = line;
                    break; // Exit the loop once data is found
                }
            }
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (foundLine != null) {
            log.info("Found: " + foundLine);
            model.addAttribute("success","Data Founded ");
            model.addAttribute("success_msg","Data Founded ! "+foundLine);
        } else {
           log.info("Data not found.");
           model.addAttribute("failure","Record is  not present");
        }

        return "search-pro";
    }


}
