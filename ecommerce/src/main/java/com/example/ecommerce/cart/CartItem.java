package com.example.ecommerce.cart;

public class CartItem implements CartComponent {
    private final String name;
    private final int quantity;
    private final double unitPrice;

    public CartItem(String name, int qty, double unitPrice){
        this.name = name; this.quantity = qty; this.unitPrice = unitPrice;
    }

    @Override public double getPrice(){ return unitPrice * quantity; }
    @Override public int getQuantity(){ return quantity; }
    @Override public String getName(){ return name; }
}
