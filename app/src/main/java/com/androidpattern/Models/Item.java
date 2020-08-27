package com.androidpattern.Models;

public class Item {

    private static String name, price, quantity;
    private double cost;

    public Item(String name, String price, String quantity) {
        Item.name = name;
        Item.price = price;
        Item.quantity = quantity;
    }

    protected static double getCost() {
       return Integer.parseInt(price) * Integer.parseInt(quantity); //calculating the total cost of an item (price x qnty)
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
