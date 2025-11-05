package com.example.demo.service;

import com.example.demo.strategy.DiscountStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PriceService {

    private final Map<String, DiscountStrategy> strategies;

    public PriceService(Map<String, DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    public double calculateFinalPrice(double amount, String strategyType) {
        DiscountStrategy strategy = strategies.get(strategyType);

        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia desconhecida: " + strategyType);
        }

        System.out.println("Aplicando: " + strategy.getName());
        return strategy.applyDiscount(amount);
    }

    public Map<String, DiscountStrategy> getAvailableStrategies() {
        return strategies;
    }
}