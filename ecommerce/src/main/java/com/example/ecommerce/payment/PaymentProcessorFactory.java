package com.example.ecommerce.payment;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class PaymentProcessorFactory {
    private final Map<String, PaymentProcessor> processors;
    public PaymentProcessorFactory(Map<String, PaymentProcessor> processors){ this.processors = processors; }
    public PaymentProcessor getProcessor(String key){
        PaymentProcessor p = processors.get(key);
        if(p==null) throw new IllegalArgumentException("Unknown payment method: "+key);
        return p;
    }
}
