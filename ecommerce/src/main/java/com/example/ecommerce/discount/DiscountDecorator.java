package com.example.ecommerce.discount;

import com.example.ecommerce.order.Order;

public abstract class DiscountDecorator implements DiscountStrategy {
    protected final DiscountStrategy wrapped;
    protected DiscountDecorator(DiscountStrategy wrapped){ this.wrapped = wrapped; }
    @Override public String name(){ return wrapped.name(); }
    @Override public double apply(double amount, Order order){ return wrapped.apply(amount, order); }
}
