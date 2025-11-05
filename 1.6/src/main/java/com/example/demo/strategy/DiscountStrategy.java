package com.example.demo.strategy;

public interface DiscountStrategy {
    double applyDiscount(double amount);
    String getName();
}
