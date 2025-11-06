package com.example.ecommerce.payment;

public abstract class PaymentProcessor {
    public final void processPayment(PaymentInfo info){
        validate(info);
        executePayment(info);
        sendNotification(info);
    }
    protected abstract void validate(PaymentInfo info);
    protected abstract void executePayment(PaymentInfo info);
    protected abstract void sendNotification(PaymentInfo info);
}
