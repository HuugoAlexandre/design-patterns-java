package com.example.demo.chain;

import com.example.demo.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderPersister extends AbstractOrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("Pedido salvo com sucesso: " + order.getId());
        order.setMessage("Pedido processado com sucesso!");
    }
}
