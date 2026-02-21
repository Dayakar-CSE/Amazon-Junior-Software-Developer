
Amazon
Handling form submissions
Introduction
Form handling is a fundamental part of building interactive web applications, especially when creating user interfaces that require user input, such as registration forms, login pages, and data entry forms. In a Spring Boot Model-View-Controller (MVC) project, handling form submissions involves setting up controllers, creating forms in the HTML view, and binding form data to model attributes to process and validate user input seamlessly.

Spring MVC provides a powerful framework for building web applications with features that streamline form handling. These features include binding form inputs to model attributes, validating data, and returning the processed information to the view. 

Let's review the core concepts and components involved in Spring MVC form handling.

Key components in Spring MVC form handling
In Spring MVC, handling form data relies on three essential components to manage data flow and user interactions. These components include:

Model: This holds the data that the application needs. In Spring MVC, a model is an object that contains the data you want to display in a view or process in the controller. It’s a Plain Old Java Object (POJO) annotated with @ModelAttribute.

View: The view is responsible for rendering the data from the model to the user. Form tags (<form></form>) render the equivalent HTML form fields and bind the object in the model with the form.

Controller: The controller is the central component that handles the HTTP request and response. It processes user inputs, interacts with the model, and sends data to the view.

Steps in handling a form submission with Spring MVC 
Based on the three key components mentioned earlier, you'll create a form submission in only three steps. Let's consider the application ‘Coffee Shop Menu’.

Step 1: Set up model attributes
The first step in effectively handling form data in Spring MVC is to set up model attributes by defining a class representing the form data. This class, also known as a form-backing object, serves as a container for the data collected from the user and bound to the form fields. 

For instance, if you're building a form to gather details about a menu item in the coffee shop, you would create a class that represents the attributes of this menu item, such as its ID, name, and price. In the example below, you can define a Product class to hold the relevant data for each menu item:

1234567891011
// Product.java
package com.coffeeshop.menu.model;

public class Product {
    private int id;
    private String name;
    private double price;
    
    // Constructors, standard getters, and setters
}

This Product class acts as our form-backing object, providing a structured way to store user input data that Spring MVC can bind to the form and easily pass between the view, model, and controller layers."

Step 2: Create Thymeleaf form
After defining the model attribute for your form data, the next step is to create a Thymeleaf form that collects all data required for the coffee shop menu. This form will enable users to input information about each new product to be displayed in the menu. 

To set this up, create a file named add-new-product.html under the src/main/resources/templates directory. In this HTML file, declare the XML namespace for Thymeleaf at the top to ensure the correct syntax is recognized:

123
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">

With Thymeleaf, you can mix standard HTML form tags with Thymeleaf-specific attributes, which makes it easy to bind form fields to model properties. 

In the example below, the th:action attribute specifies the URL for the form submission, directing it to the endpoint associated with the @PostMapping method in the controller. The form is set to POST to the /addNewProduct URL by th:action="@{/addNewProduct}".

12131415161110987654321
<form th:action="@{/addNewProduct}" method="post">
    <label for="id">ID:</label>
    <input type="number" id="id" name="id">
    <br>
    
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    <br>
    
    <label for="price">Price:</label>
    <input type="number" id="price" name="price">
    <br>
    
    <button type="submit">Add Product</button>
</form>

This HTML form, integrated with Thymeleaf attributes, gathers the new product's id, name, and price, allowing Spring MVC to capture and process the data upon submission.

Step 3: Create a controller to handle the form submission
Once the form for adding a new product is set up, the next step is to create a controller that can handle form submissions. When a user clicks the ‘Add Product’ button, the form sends an HTTP POST request to the specified URL (/addNewProduct). To process this request, you need to code a handler method in the controller class that will capture the data and update the product list.

In Spring MVC, the @PostMapping annotation maps specific URLs to handler methods designed to handle HTTP POST requests. This annotation is particularly useful for RESTful web services, as it simplifies handling data submitted through POST requests. Essentially, @PostMapping is a shortcut for @RequestMapping with method = RequestMethod.POST, streamlining the associating URLs with methods that accept and process form data.

Below is an example controller class, ProductController.java, which includes methods to handle product display, form display, and form submission:

// ProductController.java
package com.coffeeshop.menu.controller;

import com.coffeeshop.menu.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private List<Product> productsList = new ArrayList<>(List.of(
        new Product(1, "Espresso", 2.50),
        new Product(2, "Latte", 3.50),
        new Product(3, "Croissant", 2.00),
        new Product(4, "Chocolate Muffin", 2.25),
        new Product(5, "Americano", 2.75)
    ));

    @RequestMapping("/")  // Maps to the URL http://localhost:8080/
    public String listProducts(Model productListModel) {
        productListModel.addAttribute("products", productsList);  // Add productsList to the model
        return "menu";  // Returns the view name (HTML file name)
    }

    @RequestMapping("/add")  // Maps to the URL http://localhost:8080/add
    public String showProductForm(Model productAddFormModel) {
        productAddFormModel.addAttribute("product", new Product());  // Add a new product instance to the model
        return "add-new-product";
    }

    @PostMapping("/addNewProduct")  // Handles the form submission
    public String addProduct(Product product) {
        productsList.add(product);  // Adds the submitted product to productsList
        System.out.println(productsList);  // Logs the updated product list
        return "redirect:/";  // Redirects back to the main product list view
    }
}


In this example, @RequestMapping("/") maps to the homepage URL, displaying the current product list. The @RequestMapping("/add") method loads the form view where users can enter product details. Finally, @PostMapping("/addNewProduct") handles the form submission, adding the new product to productsList and redirecting to the main product list view to display the updated list.

Conclusion
Spring MVC’s form handling streamlines input processing by leveraging annotations and templates, which helps separate form-related logic for cleaner and more maintainable code. The framework also offers strong support for handling complex form submissions, making it a popular choice for web application development.

