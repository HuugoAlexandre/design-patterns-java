package com.example.ecommerce.cart;

import org.springframework.stereotype.Component;

@Component("flat")
public class FlatRateShipping implements ShippingStrategy {
    @Override public double calculate(Cart cart) { return 15.0; }
    @Override public String name(){ return "Flat Rate"; }
}
