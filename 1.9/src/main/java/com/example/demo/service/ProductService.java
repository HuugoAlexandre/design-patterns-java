package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Product;
import java.util.List;

@Service
public class ProductService {
    public boolean checkAvailability(List<Product> products) {
        System.out.println("Verificando disponibilidade dos produtos...");
        return !products.isEmpty();
    }
}
