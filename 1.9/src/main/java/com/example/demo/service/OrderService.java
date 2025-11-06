package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import java.util.List;

@Service
public class OrderService {
    public String createOrder(Customer customer, List<Product> products) {
        System.out.println("Criando pedido para o cliente: " + customer.getName());
        return "ORDER-" + System.currentTimeMillis();
    }
}
