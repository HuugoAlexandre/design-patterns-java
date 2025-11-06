package com.example.ecommerce.cart;

import org.springframework.stereotype.Component;

@Component("freeOver")
public class FreeOverShipping implements ShippingStrategy {
    private final double threshold = 300.0;
    @Override public double calculate(Cart cart){ return cart.getTotal() > threshold ? 0.0 : 25.0; }
    @Override public String name(){ return "Free over " + threshold; }
}
