package com.androidpattern.Models;

public class Item {

    private String name;
    private double price;
    private int qnty;

    public Item(String name, double price, int qnty) {
        this.name = name;
        this.price = price;
        this.qnty = qnty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQnty() {
        return qnty;
    }

    public void setQnty(int qnty) {
        this.qnty = qnty;
    }
}
