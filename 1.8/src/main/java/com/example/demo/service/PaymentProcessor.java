package com.example.demo.service;

import com.example.demo.model.PaymentInfo;

public abstract class PaymentProcessor {

    // Template Method — define o fluxo principal
    public final void processPayment(PaymentInfo info) {
        validate(info);
        executePayment(info);
        sendNotification(info);
    }

    // Etapas genéricas e obrigatórias
    protected abstract void validate(PaymentInfo info);
    protected abstract void executePayment(PaymentInfo info);
    protected abstract void sendNotification(PaymentInfo info);
}
