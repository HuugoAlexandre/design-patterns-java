package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component("fixed")
public class FixedAmountDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return Math.max(amount - 20, 0); // Desconto fixo de R$20
    }

    @Override
    public String getName() {
        return "Desconto Fixo (R$20)";
    }
}