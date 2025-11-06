package com.example.ecommerce.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartComponent> items = new ArrayList<>();
    public void add(CartComponent c){ items.add(c); }
    public double getTotal(){ return items.stream().mapToDouble(CartComponent::getPrice).sum(); }
    public List<CartComponent> getItems(){ return items; }
}
