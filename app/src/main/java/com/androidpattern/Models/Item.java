package com.androidpattern.Models;

public class Item {

    private String name, price, quantity;

    public Item(String name, String price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    protected double getCost() {
       return Integer.parseInt(this.price) * Integer.parseInt(this.quantity); //calculating the total cost of an item (price x qnty)
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
