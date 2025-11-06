package com.example.ecommerce.integration;

import org.springframework.stereotype.Component;
import com.example.ecommerce.payment.PaymentInfo;
import java.util.Map;

@Component
public class IntegrationFacade {
    private final Map<String, ExternalPaymentGateway> gateways;
    public IntegrationFacade(Map<String, ExternalPaymentGateway> gateways){ this.gateways = gateways; }

    public boolean processPayment(String gatewayKey, PaymentInfo info){
        ExternalPaymentGateway gw = gateways.get(gatewayKey);
        if(gw==null) throw new IllegalArgumentException("Gateway not found: "+gatewayKey);
        return gw.charge(info);
    }
}
