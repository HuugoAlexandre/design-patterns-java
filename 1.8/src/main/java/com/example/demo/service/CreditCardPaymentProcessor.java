package com.example.demo.service;

import com.example.demo.model.PaymentInfo;
import org.springframework.stereotype.Service;

@Service
public class CreditCardPaymentProcessor extends PaymentProcessor {

    @Override
    protected void validate(PaymentInfo info) {
        System.out.println("Validando cartão de crédito...");
    }

    @Override
    protected void executePayment(PaymentInfo info) {
        System.out.println("Processando pagamento via cartão...");
    }

    @Override
    protected void sendNotification(PaymentInfo info) {
        System.out.println("Enviando recibo do cartão para " + info.getAccount());
    }
}
