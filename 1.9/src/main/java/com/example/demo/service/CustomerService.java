package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Customer;

@Service
public class CustomerService {
    public boolean validateCustomer(Customer customer) {
        System.out.println("Validando cliente: " + customer.getName());
        return customer.getId() != null;
    }
}
