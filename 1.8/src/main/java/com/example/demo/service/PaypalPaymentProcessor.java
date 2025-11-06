package com.example.demo.service;

import com.example.demo.model.PaymentInfo;
import org.springframework.stereotype.Service;

@Service
public class PaypalPaymentProcessor extends PaymentProcessor {

    @Override
    protected void validate(PaymentInfo info) {
        System.out.println("Verificando conta PayPal...");
    }

    @Override
    protected void executePayment(PaymentInfo info) {
        System.out.println("Transferindo via PayPal...");
    }

    @Override
    protected void sendNotification(PaymentInfo info) {
        System.out.println("Enviando confirmação PayPal para " + info.getAccount());
    }
}
