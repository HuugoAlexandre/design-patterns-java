package com.example.ecommerce.discount;

import com.example.ecommerce.order.Order;

public interface DiscountStrategy {
    double apply(double amount, Order order);
    String name();
}
