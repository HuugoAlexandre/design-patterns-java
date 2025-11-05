package com.example.demo.legacy;

public interface LegacyPaymentProcessor {
    String processPayment(String orderId, double amount);
}
