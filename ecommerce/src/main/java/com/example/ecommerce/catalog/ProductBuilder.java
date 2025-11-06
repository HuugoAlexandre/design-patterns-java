package com.example.ecommerce.catalog;

import java.util.HashMap;
import java.util.Map;

public class ProductBuilder {
    private String id, name;
    private double price;
    private int stock;
    private Map<String,String> attrs = new HashMap<>();

    public ProductBuilder id(String id){ this.id=id; return this; }
    public ProductBuilder name(String name){ this.name=name; return this; }
    public ProductBuilder price(double p){ this.price=p; return this; }
    public ProductBuilder stock(int s){ this.stock=s; return this; }
    public ProductBuilder attr(String k,String v){ attrs.put(k,v); return this; }

    public SimpleProduct buildSimple() {
        SimpleProduct p = new SimpleProduct();
        p.id = id; p.name = name; p.price = price; p.stock = stock;
        p.setAttributes(attrs);
        return p;
    }
}
