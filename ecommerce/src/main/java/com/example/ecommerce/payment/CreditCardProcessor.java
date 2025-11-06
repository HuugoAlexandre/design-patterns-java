package com.example.ecommerce.payment;

import org.springframework.stereotype.Component;

@Component("card")
public class CreditCardProcessor extends PaymentProcessor {
    @Override protected void validate(PaymentInfo info){ System.out.println("[Payment] Validate card for " + info.getAccount()); }
    @Override protected void executePayment(PaymentInfo info){ System.out.println("[Payment] Charging card " + info.getAccount() + " amount " + info.getAmount()); }
    @Override protected void sendNotification(PaymentInfo info){ System.out.println("[Payment] Notify card payment to " + info.getAccount()); }
}
