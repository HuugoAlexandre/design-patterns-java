package com.example.ecommerce.order;

public abstract class AbstractOrderHandler implements OrderHandler {
    protected OrderHandler next;
    @Override public OrderHandler setNext(OrderHandler next){ this.next = next; return next; }
    protected void next(Order order){ if(next!=null && order.isValid()) next.handle(order); }
}
