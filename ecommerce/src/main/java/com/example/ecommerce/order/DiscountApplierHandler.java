package com.example.ecommerce.order;

import org.springframework.stereotype.Component;
import com.example.ecommerce.discount.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DiscountApplierHandler extends AbstractOrderHandler {
    private final DiscountService discountService;
    @Autowired
    public DiscountApplierHandler(DiscountService discountService){ this.discountService = discountService; }

    @Override public void handle(Order order){
        // for demo apply percentage only, or use request to pass strategy keys
        String[] keys = new String[]{"percentage"};
        double after = discountService.applyCombined(keys, order.getTotal(), order);
        order.setTotal(after);
        System.out.println("[Chain] Discount applied: " + after);
        next(order);
    }
}
