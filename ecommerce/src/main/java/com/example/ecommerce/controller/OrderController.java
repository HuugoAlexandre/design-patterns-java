package com.example.ecommerce.controller;

import com.example.ecommerce.order.Order;
import com.example.ecommerce.order.OrderProcessingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderProcessingService service;
    public OrderController(OrderProcessingService service){ this.service = service; }

    @PostMapping
    public Order process(@RequestBody Order order){ return service.process(order); }
}
