package com.example.productmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class add_pro {
  @GetMapping("addpro")
    public String addproducts()
  {
    System.out.println("inside add pro page");
      return "addpro";
  }
  @PostMapping("addpro")
    public void products_insertion(@RequestParam("product-name") String productname, @RequestParam("email")String email)
  {
    System.out.println(productname);
    System.out.println(email);

    try{
      String data ="product name: "+productname+" email: "+email;
      FileWriter fw = new FileWriter("add-products.txt",true);

      fw.write("\n"+data);
      fw.close();
      System.out.println("data inserted successfully");

    }
    catch (IOException e) {
      e.printStackTrace();
      System.out.println("An error occurred while storing the form data: " + e.getMessage());
    }
  }
}
