package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.adapter.PaymentAdapter;
import com.example.demo.legacy.LegacyPaymentProcessor;
import com.example.demo.newsystem.NewPaymentSystem;

@Service
public class PaymentService {

    private final LegacyPaymentProcessor processor;

    public PaymentService() {
        this.processor = new PaymentAdapter(new NewPaymentSystem());
    }

    public String process(String orderId, double amount) {
        return processor.processPayment(orderId, amount);
    }
}
