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
    public String mod_page()
    {
        log.info("inside modify page");
        return "modify-pro";
    }
    @PostMapping("modify-pro")
    public String mod_product(@RequestParam("product-code") String m_product_code, @RequestParam("product-name") String m_product_name, @RequestParam("product-company") String m_product_company, @RequestParam("product-price")long m_product_price, @RequestParam("product-quantity")long m_product_quantity, Model model)
    {
        log.info("product to be modified having code"+m_product_code);

        String data_to_modify ="product_code:"+m_product_code+" product_name:"+m_product_name+" product_company:"+m_product_company+" price:"+m_product_price+" Quantity:"+m_product_quantity;

        try {
            File file = new File("products.txt");

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            String line;
            long foundPosition = -1;
            while ((line = raf.readLine()) != null) {
                if (line.contains(m_product_code)) {
                    foundPosition = raf.getFilePointer() - line.length(); // Adjust the position
                    break;
                }
            }

            if (foundPosition != -1) {
                raf.seek(foundPosition); // Move to the position of the found line
                raf.writeBytes(data_to_modify); // Write the new data
                log.info("Data modified and saved successfully.");
            } else {
                log.info("Data not found.");
            }

            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "modify-pro";
    }
}
