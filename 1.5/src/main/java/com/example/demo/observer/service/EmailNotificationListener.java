package com.example.demo.observer.service;


import com.example.demo.observer.model.StockPriceChangeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    @EventListener
    public void handleStockPriceChange(StockPriceChangeEvent event) {
        System.out.println("[Email] Notificação: " +
                           event.getStock().getSymbol() +
                           " alterada para R$" + event.getStock().getPrice());
    }
}