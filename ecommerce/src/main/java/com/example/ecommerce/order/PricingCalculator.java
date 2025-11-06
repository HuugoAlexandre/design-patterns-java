package com.example.ecommerce.order;

import org.springframework.stereotype.Component;
@Component
public class PricingCalculator extends AbstractOrderHandler {
    @Override public void handle(Order order){
        double total = order.getItems().size() * 100; // simplified
        order.setTotal(total);
        System.out.println("[Chain] Pricing calculated: " + total);
        next(order);
    }
}
