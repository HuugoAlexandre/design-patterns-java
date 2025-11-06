package com.example.ecommerce.order;

import org.springframework.stereotype.Component;
@Component
public class OrderPersister extends AbstractOrderHandler {
    @Override public void handle(Order order){
        order.setStatus("Order persisted. Total: " + order.getTotal());
        System.out.println("[Chain] Order persisted");
    }
}
