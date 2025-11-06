package com.example.ecommerce.discount;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.example.ecommerce.order.Order;

@Service
public class DiscountService {
    private final Map<String, DiscountStrategy> strategies;
    public DiscountService(Map<String, DiscountStrategy> strategies){ this.strategies = strategies; }

    // compose strategies by names order, using decorators for combination
    public double applyCombined(String[] keys, double amount, Order order){
        if(keys==null || keys.length==0) return amount;
        DiscountStrategy base = strategies.get(keys[0]);
        if(base==null) throw new IllegalArgumentException("Unknown discount: "+keys[0]);
        DiscountStrategy composed = base;
        for(int i=1;i<keys.length;i++){
            DiscountStrategy next = strategies.get(keys[i]);
            if(next==null) throw new IllegalArgumentException("Unknown discount: "+keys[i]);
            // wrap: next applied after composed => we model by ExtraFixedDecorator only for example, but to keep generic:
            // We'll build a decorator that applies 'next' after 'composed'
            composed = new ChainedDiscountDecorator(composed, next);
        }
        return composed.apply(amount, order);
    }
}
