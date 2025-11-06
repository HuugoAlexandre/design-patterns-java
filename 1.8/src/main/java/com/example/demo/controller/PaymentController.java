package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.PaymentInfo;
import com.example.demo.service.PaymentProcessor;
import com.example.demo.service.PaymentProcessorFactory;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentProcessorFactory factory;

    public PaymentController(PaymentProcessorFactory factory) {
        this.factory = factory;
    }

    @PostMapping
    public String processPayment(@RequestBody PaymentInfo info) {
        PaymentProcessor processor = factory.getProcessor(info.getMethod());
        processor.processPayment(info);
        return "Pagamento processado com sucesso via " + info.getMethod();
    }
}
