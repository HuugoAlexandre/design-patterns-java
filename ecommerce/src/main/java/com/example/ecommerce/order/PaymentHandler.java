package com.example.ecommerce.order;

import org.springframework.stereotype.Component;
import com.example.ecommerce.payment.PaymentProcessorFactory;
import com.example.ecommerce.payment.PaymentProcessor;
import com.example.ecommerce.payment.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class PaymentHandler extends AbstractOrderHandler {
    private final PaymentProcessorFactory factory;
    @Autowired
    public PaymentHandler(PaymentProcessorFactory factory){ this.factory = factory; }

    @Override public void handle(Order order){
        PaymentInfo info = order.getPaymentInfo();
        if(info==null){
            order.setValid(false);
            order.setStatus("No payment info");
            return;
        }
        PaymentProcessor p = factory.getProcessor(info.getMethod());
        p.processPayment(info); // Template handles validate/execute/notify
        System.out.println("[Chain] Payment processed by " + info.getMethod());
        next(order);
    }
}
