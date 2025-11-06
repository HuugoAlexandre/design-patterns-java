package com.example.ecommerce.controller;

import com.example.ecommerce.payment.PaymentInfo;
import com.example.ecommerce.payment.PaymentProcessorFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentProcessorFactory factory;
    public PaymentController(PaymentProcessorFactory factory){ this.factory = factory; }

    @PostMapping
    public String pay(@RequestBody PaymentInfo info){
        factory.getProcessor(info.getMethod()).processPayment(info);
        return "OK";
    }
}
