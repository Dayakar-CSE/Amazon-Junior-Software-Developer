package com.coffeeshop.menu.controller;

import com.coffeeshop.menu.model.Product;
import com.coffeeshop.menu.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ProductController {

    @Autowired
    private ProductService productService;

    //display list of products
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "menu";
    }
    // This maps to the URL http://localhost:8080/products/
    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
    //create model attribute to bind form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-new-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {

        //save product to database
       productService.saveProduct(product);
       return "redirect:/";
    }

    //TODO 10: create a method in ProductController and annotate it with GetMapping annotation and id
    @GetMapping("/showFormForUpdate/{id}")
    //TODO 11: Use @PathVariable in method argument to id from thyme leaf tag
    public String showFormForUpdate(@PathVariable int id, Model model) {

        //TODO 12: get product from the service
        Product product = productService.getProductById(id);
        //TODO 13: set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "update-product";
    }

    // TODO 21: in the ProductController class add deleteById() method
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {

        //call delete employee method from service
        this.productService.deleteProductById(id);
        return "redirect:/";
    }
}
