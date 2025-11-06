package com.example.ecommerce.cart;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CartService {
    private final Map<String, ShippingStrategy> strategies;
    public CartService(Map<String, ShippingStrategy> strategies){ this.strategies = strategies; }

    public double calcShipping(Cart cart, String strategyKey){
        ShippingStrategy s = strategies.get(strategyKey);
        if(s==null) throw new IllegalArgumentException("Shipping strategy not found: "+strategyKey);
        return s.calculate(cart);
    }
}
