package com.example.ecommerce.order;

import org.springframework.stereotype.Component;
@Component
public class FraudDetector extends AbstractOrderHandler {
    @Override public void handle(Order order){
        if(order.getItems().size()>20){
            order.setValid(false);
            order.setStatus("Suspected fraud");
            return;
        }
        System.out.println("[Chain] Fraud check ok");
        next(order);
    }
}
