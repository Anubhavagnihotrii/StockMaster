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
public class mod_pro {
    @GetMapping("modify-product")
    public String mod_page() {
        log.info("inside modify page");
        return "modify-pro";
    }

    @PostMapping("modify-pro")
    public String mod_product(
            @RequestParam("product-code") String m_product_code,
            @RequestParam("product-name") String m_product_name,
            @RequestParam("product-company") String m_product_company,
            @RequestParam("product-price") long m_product_price,
            @RequestParam("product-quantity") long m_product_quantity,
            Model model) {
        log.info("product to be modified having code" + m_product_code);

        String data_to_modify = "product_code:" + m_product_code +
                " product_name:" + m_product_name +
                " product_company:" + m_product_company +
                " price:" + m_product_price +
                " Quantity:" + m_product_quantity;

        try {
            File inputFile = new File("products.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains(m_product_code)) {
                    found = true;
                    writer.write(data_to_modify);
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }

            reader.close();
            writer.close();

            if (found) {
                if (inputFile.delete()) {
                    if (tempFile.renameTo(inputFile)) {
                        model.addAttribute("success", "Data modified and saved successfully.");
                        log.info("Data modified and saved successfully.");
                    } else {
                        model.addAttribute("failure", "Unable to Modify the Data.");
                        log.info("Failed to rename temp file to the original file name.");
                    }
                } else {
                    log.info("Failed to delete the original file.");
                }
            } else {
                model.addAttribute("failure", "Unable to Modify the Data.");
                log.info("Data not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "modify-pro";
    }
}
