package com.example.ecommerce.payment;

public class PaymentInfo {
    private String method; // "card","paypal","bank"
    private String account;
    private double amount;
    
    public PaymentInfo() {}

    // Construtor completo (opcional)
    public PaymentInfo(String method, String account, double amount) {
        this.method = method;
        this.account = account;
        this.amount = amount;
    }
    
    public String getMethod(){ return method; }
    public void setMethod(String m){ method = m; }
    public String getAccount(){ return account; }
    public void setAccount(String a){ account = a; }
    public double getAmount(){ return amount; }
    public void setAmount(double a){ amount = a; }
}
