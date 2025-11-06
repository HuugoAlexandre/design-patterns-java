package com.example.demo.model;

import java.util.List;

public class Order {
    private String id;
    private List<String> items;
    private double total;
    private boolean valid = true;
    private String message;

    // Getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public boolean isValid() { return valid; }
    public void setValid(boolean valid) { this.valid = valid; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
