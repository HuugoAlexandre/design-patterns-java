package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PaymentService;

@RestController
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    // se der só localhost:8080/pay vai dar 404, já que pay tem param obrigatório, mas o exercício não pede pra listar, então está certo
    @GetMapping("/pay") 
    public String pay(@RequestParam String orderId, @RequestParam double amount) {
        return service.process(orderId, amount);
    }
}
