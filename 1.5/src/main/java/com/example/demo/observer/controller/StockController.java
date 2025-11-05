package com.example.demo.observer.controller;

import com.example.demo.observer.service.StockMarket;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockMarket stockMarket;

    public StockController(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }

    @PostMapping("/update")
    public String updateStock(@RequestParam String symbol, @RequestParam double price) {
        stockMarket.updateStockPrice(symbol, price);
        return "Evento de atualização enviado para a ação: " + symbol;
    }
}
