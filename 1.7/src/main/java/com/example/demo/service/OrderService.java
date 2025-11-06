package com.example.demo.service;

import com.example.demo.chain.*;
import com.example.demo.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderHandler chain;

    public OrderService(
            InventoryValidator inventoryValidator,
            FraudDetector fraudDetector,
            PricingCalculator pricingCalculator,
            DiscountApplier discountApplier,
            OrderPersister orderPersister
    ) {
        // Encadeia os handlers na ordem correta
        inventoryValidator
                .setNext(fraudDetector)
                .setNext(pricingCalculator)
                .setNext(discountApplier)
                .setNext(orderPersister);

        this.chain = inventoryValidator; // Primeiro da cadeia
    }

    public Order processOrder(Order order) {
        chain.handle(order);
        return order;
    }
}
