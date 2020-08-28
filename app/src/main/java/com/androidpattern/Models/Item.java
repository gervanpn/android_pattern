package com.androidpattern.Models;

public class Item {

    private String name, price, quantity;
    private int id;

    public Item(String name, String price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = name.hashCode();
    }

    public double getCost() {
       return Double.parseDouble(this.price) * Double.parseDouble(this.quantity); //calculating the total cost of an item (price x qnty)
    }

    public int getId() {
        return id;
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
