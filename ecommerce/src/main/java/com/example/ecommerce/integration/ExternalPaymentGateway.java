package com.example.ecommerce.integration;

import com.example.ecommerce.payment.PaymentInfo;

public interface ExternalPaymentGateway {
    boolean charge(PaymentInfo info);
    String name();
}
