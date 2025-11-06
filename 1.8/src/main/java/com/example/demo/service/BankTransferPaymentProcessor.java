package com.example.demo.service;

import com.example.demo.model.PaymentInfo;
import org.springframework.stereotype.Service;

@Service
public class BankTransferPaymentProcessor extends PaymentProcessor {

    @Override
    protected void validate(PaymentInfo info) {
        System.out.println("Validando dados bancários...");
    }

    @Override
    protected void executePayment(PaymentInfo info) {
        System.out.println("Realizando transferência bancária...");
    }

    @Override
    protected void sendNotification(PaymentInfo info) {
        System.out.println("Enviando comprovante bancário para " + info.getAccount());
    }
}
