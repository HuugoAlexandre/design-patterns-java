package com.example.ecommerce.integration;

import org.springframework.stereotype.Component;
import com.example.ecommerce.payment.PaymentInfo;

@Component("stripe")
public class StripeAdapter implements ExternalPaymentGateway {
    private final FakeStripeClient client = new FakeStripeClient();
    @Override public boolean charge(PaymentInfo info){
        String txn = client.makeCharge(info.getAccount(), info.getAmount());
        System.out.println("[Adapter] Stripe mapped txn: " + txn);
        return txn != null;
    }
    @Override public String name(){ return "Stripe"; }
}
