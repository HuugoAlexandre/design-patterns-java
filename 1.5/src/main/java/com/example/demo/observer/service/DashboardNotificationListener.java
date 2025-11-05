package com.example.demo.observer.service;

import com.example.demo.observer.model.StockPriceChangeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DashboardNotificationListener {

    @EventListener
    public void handleStockPriceChange(StockPriceChangeEvent event) {
        System.out.println("[Dashboard] Atualização de " +
                           event.getStock().getSymbol() +
                           " -> R$" + event.getStock().getPrice());
    }
}
