package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.Product;
import com.example.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// TODO 1: Create a new Java class named ProductController in the controller package. Annotate this class with @RestController to specify that it is a Spring REST controller.
@RestController
// TODO 2: Use @RequestMapping to set the base URL for all endpoints in this controller to "/api/products".
@RequestMapping("api/products")
public class ProductController {
    // TODO 3: Declare a private field productService of type ProductService.Use @Autowired to inject an instance of ProductService.
    @Autowired
    private ProductService productService;

    // TODO 4: Define a method named getAllProducts that returns a ResponseEntity containing a list of Product objects with an HTTP 200 OK status.
    // TODO 5: Annotate this method with @GetMapping to map it to GET requests with the base URL "/api/products".

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        //TODO 6: Inside the method, Call the getAllProducts method from productService to retrieve all products from the database.
        List<Product> products = productService.getAllProducts();
        //TODO 7: Return the list of products with an HTTP 200 OK status using ResponseEntity.ok().
        return ResponseEntity.ok(products);

    }

    // TODO 8: Define a method named getProductById that takes a Long parameter named id (product ID) annotated with @PathVariable.
    // TODO 9: Annotate this method with @GetMapping("/{id}") to map it to GET requests with an ID parameter.

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // TODO 10: Inside the method, Call the getProductById method from productService to find a product by its ID.
        Product product = productService.getProductById(id);
        // TODO 11: Check if the product is not null (i.e., it was found).
        if(product != null){
            return ResponseEntity.ok(product);
        }else {
            // If found, return the product with an HTTP 200 OK status using ResponseEntity.ok().
            // If not found (product is null), return an HTTP 404 NOT FOUND status using ResponseEntity.notFound().build().
            return ResponseEntity.notFound().build();
        }
    }

    /*
    //  TODO 12: Define a method named addProduct that takes a Product object annotated with @ModelAttribute. The method returns a ResponseEntity containing the saved Product with an HTTP 200 OK status.
    // TODO 13: Annotate this method with @PostMapping("/add") to map it to POST requests made to "/api/products/add".
    public ResponseEntity<Product> addProduct(@ModelAttribute Product product) {
        // TODO 14: Inside the method, Call the addProduct method from productService to save the new product to the database.
        // TODO 15: Return the saved product with an HTTP 200 OK status using ResponseEntity.ok().
        return null;
    }

     */
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

// TODO 14: call the addProduct method from productService to save the new product to the database.
        Product savedProduct = productService.addProduct(product);
// TODO 15: return the saved product with an HTTP 200 OK status using ResponseEntity.ok().
        return ResponseEntity.ok(savedProduct);
    }


    // TODO 16: Define a method named updateProduct that takes a Long parameter named id (product ID) annotated with @PathVariable, and a Product object annotated with @RequestBody (to hold updated data). The method returns a ResponseEntity containing the updated Product object with an HTTP 200 OK status or an HTTP 404 NOT FOUND status if not found.
    // TODO 17: Annotate this method with @PutMapping("/{id}") to map it to PUT requests with an ID parameter.
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        // TODO 18: Inside the method, Call the updateProduct method from productService to update the product with the given ID. If the product is found, it will be updated with the data in productDetails.
        Product updatedProduct = productService.updateProduct(id,productDetails);
        // TODO 19: Check if updatedProduct is not null (i.e., the product was found and updated).

        // If found, return the updated product with an HTTP 200 OK status.
        // If not found, return an HTTP 404 NOT FOUND status.
        if(updatedProduct != null){
            return ResponseEntity.ok(updatedProduct);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // TODO 20: Define a method named deleteProduct that takes a Long parameter named id (product ID) annotated with @PathVariable.  The method returns a ResponseEntity containing a success message or an HTTP 404 NOT FOUND status if the product was not found.
    //TODO 21: Annotate this method with @DeleteMapping("/{id}") to map it to DELETE requests with an ID parameter.

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        // TODO 22: Inside the method, Call the deleteProduct method from productService to delete the product with the given ID. The method returns a message indicating whether the product was deleted or not.
        String result = productService.deleteProduct(id);
        // TODO 23: Check if the result message indicates that the product was successfully deleted.
        if(result.startsWith("Product deleted")) {      //result.contains("deleted")
            // If the deletion was successful, return the result message with an HTTP 200 OK status.
            return ResponseEntity.ok(result);
        }else {
            // If not, return an HTTP 404 NOT FOUND status.
            return ResponseEntity.notFound().build();
        }

    }
}
