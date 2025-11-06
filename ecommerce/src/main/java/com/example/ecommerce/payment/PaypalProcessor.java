package com.example.ecommerce.payment;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PaypalProcessor extends PaymentProcessor {
    @Override protected void validate(PaymentInfo info){ System.out.println("[Payment] Validate PayPal " + info.getAccount()); }
    @Override protected void executePayment(PaymentInfo info){ System.out.println("[Payment] Process PayPal " + info.getAccount() + " amount " + info.getAmount()); }
    @Override protected void sendNotification(PaymentInfo info){ System.out.println("[Payment] Notify PayPal " + info.getAccount()); }
}
