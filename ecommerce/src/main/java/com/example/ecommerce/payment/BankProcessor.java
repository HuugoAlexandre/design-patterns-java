package com.example.ecommerce.payment;

import org.springframework.stereotype.Component;

@Component("bank")
public class BankProcessor extends PaymentProcessor {
    @Override protected void validate(PaymentInfo info){ System.out.println("[Payment] Validate bank details " + info.getAccount()); }
    @Override protected void executePayment(PaymentInfo info){ System.out.println("[Payment] Bank transfer " + info.getAccount() + " amount " + info.getAmount()); }
    @Override protected void sendNotification(PaymentInfo info){ System.out.println("[Payment] Notify bank payment " + info.getAccount()); }
}
