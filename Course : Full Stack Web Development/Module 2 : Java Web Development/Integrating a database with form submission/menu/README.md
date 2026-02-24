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
