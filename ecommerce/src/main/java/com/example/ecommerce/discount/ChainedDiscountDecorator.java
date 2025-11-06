package com.example.ecommerce.discount;

import com.example.ecommerce.order.Order;

public class ChainedDiscountDecorator implements DiscountStrategy {
    private final DiscountStrategy first;
    private final DiscountStrategy second;
    public ChainedDiscountDecorator(DiscountStrategy first, DiscountStrategy second){
        this.first = first; this.second = second;
    }
    @Override public String name(){ return first.name() + " + " + second.name(); }
    @Override public double apply(double amount, Order order){
        double a = first.apply(amount, order);
        return second.apply(a, order);
    }
}
