package com.example.demo.chain;

import com.example.demo.model.Order;
import org.springframework.stereotype.Component;

@Component
public class FraudDetector extends AbstractOrderHandler {
    @Override
    public void handle(Order order) {
        if (order.getTotal() > 10000) {
            order.setValid(false);
            order.setMessage("Pedido suspeito de fraude.");
            return;
        }
        System.out.println("Nenhuma fraude detectada");
        next(order);
    }
}
