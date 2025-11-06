package com.example.ecommerce.catalog;

public class ProductFactory {
    public static Product createSimple(ProductBuilder builder) {
        return builder.buildSimple();
    }
}
