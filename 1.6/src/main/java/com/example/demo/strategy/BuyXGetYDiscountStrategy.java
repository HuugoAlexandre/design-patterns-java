package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component("buyxgety")
public class BuyXGetYDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        // Promoção: compre 2 e leve 3 (equivale a 33% off)
        return amount * (2.0 / 3.0);
    }

    @Override
    public String getName() {
        return "Compre 2 e leve 3 (33% off)";
    }
}
