package com.example.demo.controller;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PriceService;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    private final PriceService priceService;

    public DiscountController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam double amount, @RequestParam String strategy) {
        double finalPrice = priceService.calculateFinalPrice(amount, strategy);
        return "Preço original: R$" + amount + 
               "\nPreço final (" + strategy + "): R$" + finalPrice;
    }

    @GetMapping("/strategies")
    public Map<String, String> getStrategies() {
        return priceService.getAvailableStrategies().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getName()));
    }
}