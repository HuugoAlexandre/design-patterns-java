package com.example.ecommerce.order;

import java.util.List;
import com.example.ecommerce.payment.PaymentInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Order {
    private String id;
    private List<String> items;
    private double total;
    private boolean valid = true;
    private String status;
    private PaymentInfo paymentInfo = null;

    public Order() {}
    // getters/setters
    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }
    public List<String> getItems(){ return items; }
    public void setItems(List<String> items){ this.items = items; }
    public double getTotal(){ return total; }
    public void setTotal(double total){ this.total = total; }
    public boolean isValid(){ return valid; }
    public void setValid(boolean v){ valid = v; }
    public String getStatus(){ return status; }
    public void setStatus(String s){ status = s; }
    public PaymentInfo getPaymentInfo(){ return paymentInfo; }
    public void setPaymentInfo(PaymentInfo p){ paymentInfo = p; }
    
}
