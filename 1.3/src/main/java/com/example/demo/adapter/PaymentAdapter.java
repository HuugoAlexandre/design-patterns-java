package com.example.demo.adapter;

import com.example.demo.legacy.LegacyPaymentProcessor;
import com.example.demo.model.PaymentRequest;
import com.example.demo.newsystem.NewPaymentSystem;

public class PaymentAdapter implements LegacyPaymentProcessor {

    private final NewPaymentSystem newPaymentSystem;

    public PaymentAdapter(NewPaymentSystem newPaymentSystem) {
        this.newPaymentSystem = newPaymentSystem;
    }

    @Override
    public String processPayment(String orderId, double amount) {
        PaymentRequest request = new PaymentRequest(orderId, amount);
        return newPaymentSystem.executePayment(request);
    }
}
