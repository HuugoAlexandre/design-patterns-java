package com.example.ecommerce.discount;

import org.springframework.stereotype.Component;
import com.example.ecommerce.order.Order;

@Component("fixed")
public class FixedDiscountStrategy implements DiscountStrategy {
    private final double fixed = 20.0;
    @Override public double apply(double amount, Order order){ return Math.max(0, amount - fixed); }
    @Override public String name(){ return "Fixed R$20"; }
}
