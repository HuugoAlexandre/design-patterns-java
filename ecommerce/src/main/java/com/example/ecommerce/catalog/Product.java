package com.example.ecommerce.catalog;

public abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    protected int stock;

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public void setStock(int s) { stock = s; }
}
