
Amazon
Creating the controller
Introduction
In the previous video, you set up a data model to organize details for each product in a coffee shop. Now, you’re back in the coffee shop, managing the morning rush. Customers line up, some asking for an espresso price, others wanting the full menu, and a few ordering multiple drinks simultaneously. As the barista, you handle each request, find the details, and respond quickly.

But here’s the question: How can you direct this flow of requests in your Java application?

Controllers do just that in a Spring Boot app! They manage the flow of user requests, much like a barista serving up orders. In this reading, you'll create a controller to handle coffee shop menu requests, making your application responsive and interactive. 

What is a controller in a Spring Boot application?
In Spring Boot, a controller handles HTTP requests, like GET and POST, managing user interactions and your app's core functions. For your coffee shop app, you'll create a ProductController to manage requests for menu items.

But what do HTTP requests like GET and POST mean?
When users interact with a web app, their browser sends requests to the server, each with a method indicating the action to take. The two most common are:

GET Request: When a customer asks to see the menu or details about a product, a GET request retrieves data but doesn’t change anything.

POST Request: Like a customer placing an order, a POST request sends data to create something new, like adding a product.

This reading will focus on handling GET requests, to let users view coffee shop items.

Create the ProductController in Spring Boot
A controller is a class that handles HTTP requests in your Spring Boot app. Here, you'll create a ProductController to manage requests for the coffee shop menu.

To set up a controller, you’ll use two main annotations:

@Controller: Marks the class as a controller, allowing it to handle web requests.

@RequestMapping: Maps specific URLs to methods in the controller, directing request flow.

These annotations work like instructions, guiding the controller in handling each request type.

Set up the ProductController
Let’s start by creating a new controller class, ProductController, to manage requests for Product items. Open your Spring Boot project and follow these steps:

In the coffee shop menu project, navigate to the src/main/java folder. Locate the com.coffeeshop.menu package.

To create a new package, right-click the com.coffeeshop.menu package, then select New and Package.


Name the new package controller.


Create a new Java class called ProductController inside the controller package.

Annotate the class with @Controller. IntelliJ will suggest an import. Select the one from the org.springframework.stereotype package. 


This annotation tells Spring that ProductController is a controller, allowing it to handle web requests.

Add another annotation: @RequestMapping(“/products”). Select the suggested import from the org.springframework.web.bind.annotation package.


This organizes all product-related requests at the class level. This means that all routes within the ProductController will automatically have /products prefixed to them.

This setup is like creating a dedicated “products” section in the application. By now, your ProductController should display as follows:

12345678910
package com.coffeeshop.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products") // This means all URLs start with http://localhost:8080/products/
public class ProductController {

}
Important

Adding @RequestMapping("/products") at the top of the ProductController class makes every route in the class begin with /products. For example, if you add a method within this class that includes@RequestMapping("/list"), the full URL to access it would be /products/list.

Create a list of sample products
You'll need a list of products to see the controller methods in action. Since you already created a Product model in the video Creating the Model, you’ll use it here to provide sample product data directly within your controller.

Create a List of Product objects and initialize it as follows:

123456789101112
@Controller
@RequestMapping("/products") // This means URL's start with /products (after http://localhost:8080)
public class ProductController {

    private List<Product> productsList = List.of(
        new Product(1, "Espresso", 2.50),
        new Product(2, "Latte", 3.50),
        new Product(3, "Croissant", 2.00),
        new Product(4, "Chocolate Muffin", 2.25),
        new Product(5, "Americano", 2.75)

Tip

Import the List interface from java.util package, and the Product class from the com.coffeeshop.menu package. IntelliJ will suggest these imports.

The List.of(…) method creates an immutable list, which is great for fixed data

Create the home route
Before discussing specific requests, let’s create a home route that acts as the landing page for your coffee shop application. This route allows users to access the main page and delivers a welcome message.

Typically, the home route uses the URL /. However, with class-level mapping, this route’s URL includes /products.

12345
@RequestMapping("/") // This maps to the URL http://localhost:8080/products/
@ResponseBody
public String home() {
    return "Welcome to the Coffee Shop!";
}
Observe the following:

The method returns a message as a String, displaying plain text in the browser.

The @RequestMapping(“/”) maps to the URL containing /products/ because of the class-level mapping.

The @ResponseBody annotation directs Spring Boot to send the returned string directly as an HTTP response.

So, when the users visit http://localhost:8080/products/, this method runs and displays the message “Welcome to the Coffee Shop!”

Tip

Add proper import for the @ResponseBody annotation from the import org.springframework.web.bind.annotation package, as suggested by IntelliJ.

Run your application and open the link http://localhost:8080/products/ in your browser to verify that the message is displayed as expected.


Troubleshooting
If your output is different, explore the following list of issues:

Issue: The URL may not map correctly to your controller method.

Solution: Ensure the controller class is annotated with @Controller and has the correct @RequestMapping("/products").

Verify that the method home() has the correct @RequestMapping("/") annotation.

Issue: A Whitelabel Error Page appears, indicating a routing issue or that a view isn’t found.

Solution: Ensure the method is annotated with @ResponseBody to indicate that the return value should be written directly to the HTTP response.

Issue: Missing or incorrect dependencies in pom.xml.

Solution: Ensure that you have the correct Spring Web dependency:

1234
<dependency>
<groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-web</artifactId>
</dependency>

Issue: The controller method is not set up correctly to return a response.

Solution: Ensure the method is implemented correctly and returns a valid response string using the return keyword. 

Handle GET requests 
You can create methods in ProductController to handle each type of GET request to respond to specific requests, such as listing all products or retrieving details for a single product.

Example 1: List all products

This method iterates over the sample productList and constructs a string that includes each product’s name and price. In an actual application, this would render with a proper view. Here, you can return a string with HTML line breaks (the <br> tag) for clarity.

123456789
@RequestMapping("/list") // This maps to the URL http://localhost:8080/products/list
@ResponseBody
public String listProducts() {
    String productDisplay = "<strong>Product List:</strong> <hr>";
    for (Product product : productsList) {
        productDisplay += "Product: " + product.getId() + " - " + product.getName() + " - $" + product.getPrice() + "<br>";
    }
    return productDisplay;
}
Remember

The @RequestBody annotation directs the response to be sent directly to a web page, allowing you to include HTML tags to format the output.

The <strong> tag here makes the text bold.

The <hr> tag adds a horizontal line after the text.

This method runs when the user hits the URL http://localhost:8080/products/list.

Rerun your application, and open the specified link in your browser to verify the expected result.


Troubleshooting
Review the issues cited previously for a different output at this stage. If needed, here’s a list of more issues that could occur:

Issue: The listProducts method might have errors in the logic for displaying product details, especially if there’s an error in formatting or constructing the output string.

Solution: Ensure that you’re building the output correctly using a String.

Issue: If the productList variable hasn’t been initialized correctly or is empty, you may receive an empty result.

Solution: Ensure that productList is initialized at the class level with sample data using the List.of() method

Issue: Spring Boot is case-sensitive with URLs, so a typo or case mismatch (such as /Products/List instead of /products/list) will not route correctly and could result in an error page.

Solution: Double-check the exact case and spelling of /products/list in your browser and controller method annotations.

Example 2: View details of a specific product

Let’s create another method to view the details of a particular product by specifying its ID in the URL. This method is like showing customers the details for a specific product when they ask about a specific menu item.

12345678910
@RequestMapping("/details/{id}") // This maps to the URL http://localhost:8080/products/details/{id}
@ResponseBody
public String getProductDetailsByID(@PathVariable int id){
    for (Product product : productsList) {
        if (product.getId() == id) {
            return "<strong>Requested Product Details: </strong> <hr> Product ID: " + product.getId() + "<br> Name: " + product.getName() + "<br> Price: $" + product.getPrice();
        }
    }
    return "Product not found!";
}
The method uses a new annotation here, @PathVariable, to extract the {id} from the URL, then iterates through productList to find a matching product. If found, it returns the product details; otherwise, it returns “Product not found!”

Remember

This method is accessible at http://localhost:8080/products/details/{id}, where {id} is the specific product ID to be written without the curly braces.

The URLs that map to various methods created by you are also known as endpoints.

Let’s rerun the application and verify the results for a specific product ID, say, 2. So, your URL will be http://localhost:8080/products/details/2.



Troubleshooting
If you experience a different output, review the previous issues first, then explore the additional issues listed below:

Issue: If the product with ID 2 is not in the productsList, the method may return "Product not found!" even if the URL is correct.

Solution: Ensure that the product list contains the entry for ID 2. Check your product list initialization

Issue: If the @PathVariable is not correctly parsed as an integer, accessing a non-integer value (like /products/details/abc) will throw a NumberFormatException.

Solution: Ensure that the URL contains a valid integer. 

Issue: If the @PathVariable is not correctly specified, the method might not receive the ID as intended.

Solution: Verify that the method signature correctly uses @PathVariable int id to receive the ID from the URL.

Issue: If there are duplicate product IDs in your list, the logic for retrieving the product might return the first match, which could be misleading.

Solution: Ensure that the product list contains unique IDs or modify the retrieval logic to handle duplicates if necessary.

Here’s the complete code of the ProductController class for your reference:

12345678910111213141516171819202122232425262728293031323334353637383940


package com.coffeeshop.menu.controller;

import com.coffeeshop.menu.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/products") // This means all URLs start with http://localhost:8080/products/
public class ProductController {

    private List<Product> productsList = List.of(
        new Product(1, "Espresso", 2.50),
        new Product(2, "Latte", 3.50),
        new Product(3, "Croissant", 2.00),
        new Product(4, "Chocolate Muffin", 2.25),
        new Product(5, "Americano", 2.75)
    );

    @RequestMapping("/") // This maps to the URL http://localhost:8080/products/
    @ResponseBody
    public String home() {
        return "Welcome to the Coffee Shop!";
    }

    @RequestMapping("/list") // This maps to the URL http://localhost:8080/products/list
    @ResponseBody
    public String listProducts() {
        String productDisplay = "<strong>Product List:</strong> <hr>";
        for (Product product : productsList) {
            productDisplay += "Product: " + product.getId() + " - " + product.getName() + " - $" + product.getPrice() + "<br>";
        }
        return productDisplay;
    }

    @RequestMapping("/details/{id}") // This maps to the URL http://localhost:8080/products/details/{id}
    @ResponseBody
    public String getProductDetailsByID(@PathVariable int id){
        for (Product product : productsList) {
            if (product.getId() == id) {
                return "<strong>Requested Product Details: </strong> <hr> Product ID: " + product.getId() + "<br> Name: " + product.getName() + "<br> Price: $" + product.getPrice();
            }
        }
        return "Product not found!";
    }
}



Summary
In this reading, you created a ProductController to manage product-related requests in your coffee shop application. You used the @Controller and @RequestMapping annotations to handle and direct HTTP requests, enabling users to view a list of products or access details for a specific item. This setup allows your application to respond smoothly to user interactions, mimicking a real-world scenario. 

You also applied class-level mapping with @RequestMapping("/products"), so each route in ProductController starts with /products, providing a clear structure for product-related paths. Using sample Product data, you simulated how a real application could present information in response to GET requests. 

As you progress, you’ll learn to connect this data to a database, making the content dynamic and enriching the user experience. With this foundation, your coffee shop app can effectively handle user requests and display product details.

You can download the complete project for your reference: 


Completed

