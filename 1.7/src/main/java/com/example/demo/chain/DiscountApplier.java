package com.example.demo.chain;

import com.example.demo.model.Order;
import org.springframework.stereotype.Component;

@Component
public class DiscountApplier extends AbstractOrderHandler {
    @Override
    public void handle(Order order) {
        double discounted = order.getTotal() * 0.9; // 10% de desconto
        order.setTotal(discounted);
        System.out.println("Desconto aplicado: novo total R$" + discounted);
        next(order);
    }
}
