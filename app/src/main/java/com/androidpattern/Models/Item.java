package com.androidpattern.Models;

public class Item {

    private String _name, _price, _quantity;
    private int _itemId;

    public Item(String name, String price, String quantity) {
        this._name = name;
        this._price = price;
        this._quantity = quantity;
        this._itemId = name.hashCode();
    }

    public double getCost() {
       String temp = String.format("%.2f", Double.parseDouble(this._price));
        return Double.parseDouble(temp) * Double.parseDouble(this._quantity);
        //calculating the total cost of an item (price x qnty)
    }

    public int getId() {
        return _itemId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getPrice() {
        return _price;
    }

    public void setPrice(String price) {
        this._price = price;
    }

    public String getQuantity() {
        return _quantity;
    }

    public void setQuantity(String quantity) {
        this._quantity = quantity;
    }
}
