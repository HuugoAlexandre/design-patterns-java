package com.example.demo.observer.service;

import com.example.demo.observer.model.StockPriceChangeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationListener {

    @EventListener
    public void handleStockPriceChange(StockPriceChangeEvent event) {
        System.out.println("[SMS] Ação " + event.getStock().getSymbol() +
                           " atualizada para R$" + event.getStock().getPrice());
    }
}

