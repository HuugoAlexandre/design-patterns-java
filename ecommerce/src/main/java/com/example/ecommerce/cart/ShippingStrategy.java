package com.example.ecommerce.cart;

public interface ShippingStrategy {
    double calculate(Cart cart);
    String name();
}
