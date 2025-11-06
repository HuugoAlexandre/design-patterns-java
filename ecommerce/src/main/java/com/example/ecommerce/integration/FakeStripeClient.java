package com.example.ecommerce.integration;

public class FakeStripeClient {
    public String makeCharge(String token, double amount){
        System.out.println("[StripeSDK] Charging " + token + " amount " + amount);
        return "stripe_txn_123";
    }
}
