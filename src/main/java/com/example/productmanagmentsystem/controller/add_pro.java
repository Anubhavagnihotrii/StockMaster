package com.example.productmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class add_pro {
  @GetMapping("add-pro")
  public String add_products() {
    System.out.println("inside add pro page");
    return "add-pro";
  }

  @PostMapping("add-pro")
  public String products_insertion(@RequestParam("product-code") String product_code,
      @RequestParam("product-name") String product_name, @RequestParam("product-company") String product_company,
      @RequestParam("product-price") long product_price, @RequestParam("product-quantity") long product_quantity,
      Model model) {
    System.out.println("Inside products entry form");
    System.out.println(product_code + product_name + product_company + product_price + product_quantity);

    try {
      String data = "product_code:" + product_code + " product_name:" + product_name + " product_company:"
          + product_company + " price:" + product_price + " Quantity:" + product_quantity;
      FileWriter fw = new FileWriter("products.txt", true);

      fw.write("\n\n" + data);
      fw.close();
      System.out.println("data inserted successfully");

      model.addAttribute("success", "Data Inserted Successfully !");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("An error occurred while storing the form data: " + e.getMessage());
    }
    return "add-pro";
  }
}
