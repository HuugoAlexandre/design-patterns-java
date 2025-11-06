package com.example.ecommerce.catalog;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RestockListenerConsole {

    @EventListener
    public void handle(ProductRestockedEvent event){
        System.out.println("[EVENT] Product restocked: " + event.getProductId());
    }
}
