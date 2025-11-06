package com.example.demo.chain;

import com.example.demo.model.Order;
import org.springframework.stereotype.Component;

@Component
public class InventoryValidator extends AbstractOrderHandler {
    @Override
    public void handle(Order order) {
        if (order.getItems() == null || order.getItems().isEmpty()) {
            order.setValid(false);
            order.setMessage("Falha: Pedido sem itens no estoque.");
            return;
        }
        System.out.println("Estoque verificado");
        next(order);
    }
}
