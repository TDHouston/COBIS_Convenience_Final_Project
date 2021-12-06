package com.company;

import java.util.ArrayList;

public class Receipt {
    private ArrayList<Products> customerprods = new ArrayList<Products>();
    private String customername;
    private double receipttotal;

    public double getReceipttotal() {
        return receipttotal;
    }

    public void setReceipttotal(double receipttotal) {
        this.receipttotal = receipttotal;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public ArrayList<Products> getCustomerprods() {
        return customerprods;
    }

    public void addCustomerprods(Products products) {
        customerprods.add(products);
    }
}
