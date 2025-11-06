package com.example.demo.chain;

import com.example.demo.model.Order;
import org.springframework.stereotype.Component;

@Component
public class PricingCalculator extends AbstractOrderHandler {
    @Override
    public void handle(Order order) {
        double total = order.getItems().size() * 100;
        order.setTotal(total);
        System.out.println("Preço calculado: R$" + total);
        next(order);
    }
}
