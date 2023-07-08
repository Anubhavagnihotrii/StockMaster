package com.example.productmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class del_pro {
    @GetMapping("del-pro")
    public String del_product() {
        return "del-pro";
    }

    @PostMapping("del-pro")
    public String delete_pro(@RequestParam("product-code") String product_code,
            @RequestParam("product-name") String product_name, Model model) {
        System.out.println(product_code);
        System.out.println(product_name);

        try {
            List<String> lines = Files.readAllLines(Paths.get("products.txt"));

            System.out.println("Current file contents:");
            for (String line : lines) {
                System.out.println(line);
            }

            List<String> modifiedLines = new ArrayList<>();
            boolean matchFound = false;

            for (String line : lines) {
                if (line.contains(product_code) && line.contains(product_name)) {
                    matchFound = true;
                } else {
                    modifiedLines.add(line);
                }
            }

            if (matchFound) {
                // Write the modified content back to the file
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("products.txt"));
                for (String line : modifiedLines) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.close();
                System.out.println("Matching record(s) deleted successfully.");

                model.addAttribute("success", "Product deleted Successfully");
            } else {
                System.out.println("No matching record found. No changes were made to the file.");
                model.addAttribute("failure", "No matching record found.");
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return "del-pro";
    }
}
