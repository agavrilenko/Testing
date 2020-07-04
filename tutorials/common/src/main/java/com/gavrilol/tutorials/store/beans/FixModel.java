package com.gavrilol.tutorials.store.beans;

import java.io.Serializable;

public class FixModel implements Serializable {

    private String quoteId;
    private double price;
    private double amount;
    private String symbol;

    public FixModel(String quoteId, double price, double amount, String symbol) {
        this.quoteId = quoteId;
        this.price = price;
        this.amount = amount;
        this.symbol = symbol;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
