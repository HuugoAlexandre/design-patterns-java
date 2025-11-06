package com.example.ecommerce.controller;

import com.example.ecommerce.discount.DiscountService;
import com.example.ecommerce.order.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {
    private final DiscountService service;
    public DiscountController(DiscountService service){ this.service = service; }

    @PostMapping("/apply")
    public double apply(@RequestBody Order order, @RequestParam String[] strategies){
        return service.applyCombined(strategies, order.getTotal(), order);
    }
}
