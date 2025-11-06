package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public boolean processPayment(String orderId, double amount) {
        System.out.println("Processando pagamento do pedido " + orderId + " no valor de R$ " + amount);
        return true;
    }
}
