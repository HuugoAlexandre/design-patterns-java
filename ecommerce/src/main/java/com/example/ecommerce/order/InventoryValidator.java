package com.example.ecommerce.order;

import org.springframework.stereotype.Component;
@Component
public class InventoryValidator extends AbstractOrderHandler {
    @Override public void handle(Order order){
        if(order.getItems()==null || order.getItems().isEmpty()){
            order.setValid(false);
            order.setStatus("No items");
            return;
        }
        System.out.println("[Chain] Inventory ok");
        next(order);
    }
}
