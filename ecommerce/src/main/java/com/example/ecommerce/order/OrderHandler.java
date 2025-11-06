package com.example.ecommerce.order;

public interface OrderHandler {
    OrderHandler setNext(OrderHandler next);
    void handle(Order order);
}
