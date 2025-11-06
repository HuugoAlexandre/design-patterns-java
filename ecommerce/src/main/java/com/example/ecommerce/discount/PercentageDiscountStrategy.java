package com.example.ecommerce.discount;

import org.springframework.stereotype.Component;
import com.example.ecommerce.order.Order;

@Component("percentage")
public class PercentageDiscountStrategy implements DiscountStrategy {
    private final double pct = 0.10; // 10%
    @Override public double apply(double amount, Order order){ return amount * (1 - pct); }
    @Override public String name(){ return "Percentage 10%"; }
}
