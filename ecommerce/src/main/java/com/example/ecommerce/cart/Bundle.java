package com.example.ecommerce.cart;

import java.util.ArrayList;
import java.util.List;

public class Bundle implements CartComponent {
    private final String name;
    private final List<CartComponent> children = new ArrayList<>();

    public Bundle(String name){ this.name = name; }
    public void add(CartComponent c){ children.add(c); }
    @Override public double getPrice(){ return children.stream().mapToDouble(CartComponent::getPrice).sum(); }
    @Override public int getQuantity(){ return children.stream().mapToInt(CartComponent::getQuantity).sum(); }
    @Override public String getName(){ return name; }
}
