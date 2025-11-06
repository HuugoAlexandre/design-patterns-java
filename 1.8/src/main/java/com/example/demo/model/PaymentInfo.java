package com.example.demo.model;

public class PaymentInfo {
    private String method;
    private String account;
    private double amount;

    public PaymentInfo() {}

    public PaymentInfo(String method, String account, double amount) {
        this.method = method;
        this.account = account;
        this.amount = amount;
    }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
