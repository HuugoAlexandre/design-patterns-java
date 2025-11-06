package com.example.ecommerce.discount;

import com.example.ecommerce.order.Order;

public class ExtraFixedDecorator extends DiscountDecorator {
    private final double extra;
    public ExtraFixedDecorator(DiscountStrategy wrapped, double extra){
        super(wrapped); this.extra = extra;
    }
    @Override public double apply(double amount, Order order){
        double prev = super.apply(amount, order);
        return Math.max(0, prev - extra);
    }
    @Override public String name(){ return wrapped.name() + " + extra R$" + extra; }
}
