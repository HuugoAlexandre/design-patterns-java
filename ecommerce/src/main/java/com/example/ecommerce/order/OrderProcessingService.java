package com.example.ecommerce.order;

import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {
    private final OrderHandler chain;

    public OrderProcessingService(InventoryValidator inventory,
                                  FraudDetector fraud,
                                  PricingCalculator pricing,
                                  DiscountApplierHandler discount,
                                  PaymentHandler payment,
                                  OrderPersister persister){
        inventory.setNext(fraud).setNext(pricing).setNext(discount).setNext(payment).setNext(persister);
        this.chain = inventory;
    }

    public Order process(Order order){
        chain.handle(order);
        return order;
    }
}
