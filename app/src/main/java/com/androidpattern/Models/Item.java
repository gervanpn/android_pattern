package com.androidpattern.Models;

public class Item {

    private String name, price, quantity;
    private double cost;

    public Item(String name, String price, String quantity, double cost) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
