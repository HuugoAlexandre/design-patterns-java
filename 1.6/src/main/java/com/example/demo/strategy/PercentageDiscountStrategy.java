package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component("percentage")
public class PercentageDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.90; // 10% de desconto
    }

    @Override
    public String getName() {
        return "Desconto Percentual (10%)";
    }
}