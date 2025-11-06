package com.example.ecommerce.catalog;

import java.util.Map;
import java.util.HashMap;

public class SimpleProduct extends Product {
    private Map<String,String> attributes = new HashMap<>();
    public Map<String,String> getAttributes(){ return attributes; }
    public void setAttributes(Map<String,String> a){ attributes = a; }
}
