
Amazon
Activity: Using Spring data JPA for database operations
Because your online store has expanded, you need to store and track a lot more information. You have to store customer details, products, and orders. You also have to manage operations like adding new items, updating prices, or deleting old products. What you don’t want to do is write large amounts of code. 

Traditionally, using JDBC, you would have to write lots of boilerplate code to manage database connections and queries. Spring Data JPA simplifies working with databases because it removes the need for most of the manual coding.

In this ungraded lab, you’ll learn how to create repositories using Spring Data JPA and perform basic Create, Read, Update, Delete (CRUD) operations. You’ll also discover how Spring Data JPA makes querying data easier compared to traditional JDBC.

Goal

To use Spring Data JPA to implement efficient CRUD operations for managing product data in an e-commerce application. Create a Product entity to represent the products sold on the platform and set up a ProductRepository to handle common database operations like saving, retrieving, updating, and deleting products without writing complex SQL queries. Build a service layer to manage business logic around these operations and expose CRUD operations through RESTful APIs using a ProductController to allow users or admins to manage products.

Tip

This lab will expand RBAC to implement Spring Data JPA. Before you start, if you need to refresh your knowledge of how to implement RBAC, you can refer to the item Implementing Role-Based Access Control. 

🖥️Note: When you encounter this icon, it’s time to get into your IDE and start coding!

In your lab environment, open IntelliJ by double-clicking on the icon.

The IntelliJ icon.
Requirements
In this lab, you will need to: 

Add Spring Data JPA dependency:

In the pom.xml file, include the Spring Data JPA and H2 (H2 is an in-memory database. You can switch to MySQL or PostgreSQL later.) database dependencies to enable database interactions and testing. 

Create the Product entity:

Define a Product entity class that maps to a database table. This class will contain fields such as id, name, and price to represent product details.

Create the ProductRepository interface:

Create a repository interface that extends JpaRepository. This will automatically provide methods for common CRUD operations without requiring you to write SQL queries.

Create the ProductService class:

Implement a service layer to handle business logic for managing products, such as adding new products, fetching product details, updating existing products, and deleting products.

Use the ProductRepository in this service to interact with the database.

Create the ProductController class:

Build a RESTful controller to expose CRUD operations as API endpoints. Users will be able to perform CRUD operations on products such as adding, updating, retrieving, and deleting via HTTP methods like GET, POST, PUT, and DELETE.

Update the SecurityConfig to accept URLs with basic authentication:

Change the securityFilterChain() to enforce Basic Authentication for /products/** url and not force login. 

Test CRUD Operations:

Test your endpoints using Postman or curl to verify that the CRUD operations work as expected, and allow you to add, update, delete, and retrieve product data from the database.

By implementing these changes, you will integrate Spring Data JPA into your application to simplify database operations and make your e-commerce product management more efficient and maintainable.


