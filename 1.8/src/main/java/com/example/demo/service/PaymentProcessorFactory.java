package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentProcessorFactory {

    private final CreditCardPaymentProcessor cardProcessor;
    private final PaypalPaymentProcessor paypalProcessor;
    private final BankTransferPaymentProcessor bankProcessor;

    public PaymentProcessorFactory(
        CreditCardPaymentProcessor cardProcessor,
        PaypalPaymentProcessor paypalProcessor,
        BankTransferPaymentProcessor bankProcessor) {
        this.cardProcessor = cardProcessor;
        this.paypalProcessor = paypalProcessor;
        this.bankProcessor = bankProcessor;
    }

    public PaymentProcessor getProcessor(String method) {
        return switch (method.toLowerCase()) {
            case "card" -> cardProcessor;
            case "paypal" -> paypalProcessor;
            case "bank" -> bankProcessor;
            default -> throw new IllegalArgumentException("Método de pagamento inválido: " + method);
        };
    }
}
