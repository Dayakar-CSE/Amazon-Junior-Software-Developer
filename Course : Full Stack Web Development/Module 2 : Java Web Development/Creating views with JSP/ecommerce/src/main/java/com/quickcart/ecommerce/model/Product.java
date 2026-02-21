package com.quickcart.ecommerce.model;

public class Product {

    // TODO 1: Add private fields for id, name, description, and price using appropriate data types
    private int id;
    private String name;
    private String description;
    private double price;

    // TODO 2: Generate a parameterized constructor to initialize all fields
    public Product(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // TODO 3: Generate getters and setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
