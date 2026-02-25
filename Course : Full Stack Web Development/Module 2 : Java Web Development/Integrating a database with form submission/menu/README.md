# Integrating a Database with Form Submission – Spring Data JPA

## Overview

In previous labs, product data was stored in an in-memory list.  
In this lab, the application integrates a real database using **Spring Data JPA** to persist products.

The application now supports:

- Storing products in database
- Updating products
- Deleting products

This completes the **Update and Delete** operations of CRUD.

---

# Goal

Configure Spring Data JPA and integrate a database to perform **Update** and **Delete** operations in the Spring Boot application.

---

# Concepts Practiced

- Entity class creation
- Repository interface
- Spring Data JPA
- Database integration
- CRUD operations (Update, Delete)
- Thymeleaf form binding with DB

---

# Entity Class

The `Product` class is converted into a JPA entity.

```java
package com.coffeeshop.menu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private double price;

    // constructors, getters, setters
}
```
Perform Update operation in the Database

Now, you will write a method to update the record from the products table. Therefore, create a service layer interface method.

🖥️ It’s time to get coding!

Step 1: Create a service layer interface method
TODO 1: In the ProductService interface, write a method to retrieve a Product object from the database. This method should take an id as an argument and return an object of type Product.

This is what your code might be like at this stage:

1234567891011
// ProductService.java
package com.coffeeshop.menu.service;
import com.coffeeshop.menu.model.Product;
import java.util.List;
public interface ProductService {
List<Product> getAllProducts();
void saveProduct(Product product);
// TODO 1: write a method in the ProductService interface to get the Product object from the database.
        Product getProductById(int id);
}

Step 2: Implement the method in ProductServiceImpl
In this step, you’ll implement the method to retrieve a Product by ID in the ProductServiceImpl class. Following the guidelines below, you’ll create a method that checks for the presence of a product record and handles any cases where no matching record is found.

🖥️ It’s time to get coding!

TODO 2: Create a method signature in the ProductServiceImpl class with @override annotation, return type, and method argument.

TODO 3: Insert a JpaRepositories findById() method to return an Optional object of type Product.

TODO 4: Declare a null product object.

TODO 5: Use the if-else block to see if any product record is returned.

TODO 6: If the product is returned, then assign it to the product object.

TODO 7: Otherwise, throw a Runtime Exception with a relevant message of record not found with that ID.

Here’s a code snippet to help you:
// ProductServiceImpl.java
//TODO 2: create a method signature in the ProductServiceImpl class with @override annotation, return type, and method argument.
@Override
public Product getProductById(int id) {
//TODO 3: JpaRepositories findById() method returns an Optional Object of type Product
Optional<Product> optional = productRepository.findById(id);
//TODO 4: delare a null product object.
Product product = null;
//TODO 5: use the if-else block to see if any product record is returned or not
if(optional.isPresent())
{
//TODO 6: if the product is returned then assign to product object.
product = optional.get();
}else
{
//TODO 7: else throw a Runtime Exception with a relevant message of record not found with that id.
throw new RuntimeException("Product not found for id : " + id) ;
}
return product;
}

Step 3: Add update button in the HTML home page for each record
Next, you'll add an update feature to the HTML homepage, allowing users to modify individual records directly from the main view. Follow the TODOs below to create an update button for each record, making the data more interactive and editable.

🖥️ It’s time to get coding!

TODO 8: Add a column to the table in the HTML view homepage.

TODO 9: In the Table data tag, create an Update Button as a hyperlink in the Thymeleaf tag.

Here’s a code snippet to help you:

<!-- *part of menu.html file -->
<table>
<thead>
<tr>
<th>ID</th>
        <th>Name</th>
        <th>Price</th>
		<!--TODO 8:  add a column to the table in HTML view homepage – >
        <th>Actions</th>
        </tr>
        </thead>
        <tbody>
<tr th:each="product : ${listProducts}">
        <td th:text="${product.id}"></td>
        <td th:text="${product.name}"></td>
        <td th:text="${product.price}"></td>
//TODO 9: in the Table data tag create an Update Button as a hyperlink in the thyme leaf tag.
        <td><a th:href="@{/ShowFormForUpdate/{id}(id=${product.id})}" class="button">Update</a> </td>
        </tr>
        </tbody>
        </table>


Step 4: Add Handler in Controller to handle update request
In this step, you’ll add a handler in the controller to manage update requests, enabling the application to retrieve and display product details for editing. Follow the TODOs to create a method that fetches a product by ID and pre-populates the form with its data for easy updating.

🖥️ It’s time to get coding!

TODO 10: Create a method in ProductController and annotate it with GetMapping annotation and id.

TODO 11: Use @PathVariable in the method argument to capture the id from the Thymeleaf tag. 

TODO 12: Get the product from the service.

TODO 13: Set the product as a model attribute to pre-populate the form.

Here’s a code snippet to help you:

// ProductController.java
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

Step 5: Create an update-product.html file for updating the form
Next, you’ll create an HTML file to serve as the update form, enabling users to modify existing product details. Follow the TODOs below to set up the form with the necessary fields and a submit button to handle updates.

🖥️ It’s time to get coding!

TODO 14: Create an HTML file for the update form, using the POST method and setting the form action to the same endpoint as the one used for adding a new item. 

TODO 15: Add a hidden input field to keep track of the id.

TODO 16: Use a Thymeleaf object and field tags.

TODO 17: Add the Update Button.

Here’s a code snippet to help you:

<!-- update-product.html –>
        <!--TODO 14: create an html file for the update form with post method and the same action as adding new item-->
form action="#" th:action="@{/saveProduct}" th:object="${product}" method="post">
        <!--TODO 15: add a hidden input field to keep track of id-->
        <input type="hidden" th:field="*{id}" />
        <label for="name">
        Name:
        </label>
<!--TODO 16: use thyme leaf object and field tags-->
        <input type="text" id="name" name="name" th:field="*{name}">
        <br>
<label for="price">
        Price:
        </label>
        <input type="text" id="price" name="price" th:field="*{price}">
        <br>
<!--TODO 17: add Update Button –->
        <button type="submit">
        Update Item
</button>
</form>


Perform delete operation on record in database


inLabInstructionsPart~uSNffqz2Ee-8nA7ehSWC6w
​
In this task, you'll implement a delete feature that allows users to remove items directly from the homepage. You'll start by adding a delete button for each record, then proceed to define and implement the delete functionality within the service layer. Finally, you'll create a handler in the controller to process delete requests, enabling efficient item removal from the database.

Step 1: Add Delete Button
To allow users to remove items directly from the homepage, you’ll add a delete button next to each record. Follow the tasks below to create a Delete button as a hyperlink within the table, providing easy access to delete individual items.

🖥️ It’s time to get coding!

TODO 18: On the HTML homepage, add a Delete button. Create an additional hyperlink next to the update button within the table tags and label it as DELETE.

Here’s a code snippet to help you:

123456
<td>
<a th:href="@{/showFormForUpdate/{id}(id=${product.id})}" class="button">Update</a>
<!--TODO 18: On the HTML homepage, add a Delete button. Create an additional hyperlink next to the update button within the table tags and label it as DELETE -- >
<a th:href="@{/deleteProduct/{id}(id=${product.id})}" class="button">Delete</a>
        </td>

Step 2: Add the delete method in the service interface
Now, you’ll add a delete method to the ProductService interface, enabling the removal of products from the database. 

🖥️ It’s time to get coding!

TODO 19: In the ProductService interface, add the method for delete.

Here’s a code snippet to help you:

1234567891011
package com.coffeeshop.menu.service;
import com.coffeeshop.menu.model.Product;
import java.util.List;
public interface ProductService {
List<Product> getAllProducts();
void saveProduct(Product product);
Product getProductById(int id);
//TODO 19:  in ProductService interface add the method
        void deleteProductById(int id);
}

Step 3: override delete method in service class
Next, implement the delete functionality by overriding the delete method in the ProductService class. Use the deleteById() method from JpaRepository to enable deletion by product ID.

🖥️ It’s time to get coding!

TODO 20: In the ProductService class, add the deleteById() method from the JpaRepository.

Here’s a code snippet to help you:

123456
//TODO 20: in the ProductService class add the deleteById() method from JpaRepository
@Override
public void deleteProductById(int id) {
this.productRepository.deleteById(id);
}

Step 4: Add handler for delete method in ProductController
Finally, add a handler for the delete method in the ProductController class. Implement the deleteById() method to handle delete requests based on product ID.

🖥️ It’s time to get coding!

TODO 21: In the ProductController class, add the deleteById() method.

Here’s a code snippet to help you:

12345678
