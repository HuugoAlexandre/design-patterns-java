package com.example.demo.chain;

import com.example.demo.model.Order;

public interface OrderHandler {
    void handle(Order order);
    OrderHandler setNext(OrderHandler next);
}
