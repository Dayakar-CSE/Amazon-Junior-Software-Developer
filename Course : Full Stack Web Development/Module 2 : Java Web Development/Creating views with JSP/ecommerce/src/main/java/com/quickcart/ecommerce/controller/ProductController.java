package com.quickcart.ecommerce.controller;

import com.quickcart.ecommerce.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

// TODO 4: Add the @Controller annotation to declare the class as a controller
@Controller
public class ProductController {

    //TODO 5: Create a public method named getProducts that accepts a Model object as argument and returns a String representing the view name
    // TODO 5a: Add the @GetMapping annotation with the value "/products" to map the method to the URL "/products"

    @GetMapping({"/", "/products"})
    public String getProducts(Model productModel) {
        // TODO 6: Declare a List of Product objects and initialize it with an empty ArrayList
        List<Product> products = new ArrayList<>();

        // TODO 7: Create three new Product objects, namely, Laptop, Smartphone, and Headphones with details
        Product laptop = new Product(1, "Laptop", "A laptop for work and play", 500.0);
        Product smartphone = new Product(2, "Smartphone", "A smartphone for communication", 300.0);
        Product headphones = new Product(3, "Headphones", "A pair of headphones for music", 50.0);

        // TODO 8: Add the three Product objects to the List of products
        products.add(laptop);
        products.add(smartphone);
        products.add(headphones);

        // TODO 9: Add the List of products to the Model object with the key "products"
        productModel.addAttribute("products", products);

        // TODO 10: Return the view name "products" as a String
        return "products";
    }

}
