package com.example.demo.newsystem;

import com.example.demo.model.PaymentRequest;

public class NewPaymentSystem {

    public String executePayment(PaymentRequest request) {
        return "Pagamento processado com sucesso no novo sistema: " +
               "Pedido " + request.getOrderId() +
               " | Valor: R$ " + request.getAmount();
    }
}
