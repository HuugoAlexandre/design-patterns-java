package com.example.demo.observer.service;

import com.example.demo.observer.model.Stock;
import com.example.demo.observer.model.StockPriceChangeEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class StockMarket {

    private final ApplicationEventPublisher publisher;

    public StockMarket(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void updateStockPrice(String symbol, double newPrice) {
        Stock stock = new Stock(symbol, newPrice);
        publisher.publishEvent(new StockPriceChangeEvent(this, stock));
        System.out.println("Atualização de preço publicada: " + symbol + " -> R$" + newPrice);
    }
}
