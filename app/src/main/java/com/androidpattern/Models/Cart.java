package com.androidpattern.Models;

import java.util.ArrayList;

public class Cart {

    //variables
    static private ArrayList<Item> items = new ArrayList<>();

    //constructor
    public Cart() {
    }

    //getter methods
    public static ArrayList<Item> getItems() {
        return items;
    }

    public static int getItemId(int index) {
        return items.get(index).getId();
    }

    public static String getItemName(int ind) {
        return items.get(ind).getName();
    }

    public static double getTotalCost() {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getCost();
        }
        ;
        return totalCost;
    }

    public static int getQuantity() {
        return items.size();
    }

    public static void removeItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) items.remove(i);
        }
    }

    //setter methods
    public static void addItem(Item item) {
        Cart.items.add(item);
    }

    //helper methods
    public static void clearCart() {
        items.clear();
    }

}
