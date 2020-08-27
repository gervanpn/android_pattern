package com.androidpattern.Models;

import java.util.ArrayList;

public class Cart {

    static private ArrayList<Item> items = new ArrayList<>();
    static private double totalCost = 0;

    private Cart() {
    }

    public static void addItem(Item item) {
        items.add(item);
        setTotalCost();
    }

    public static double getTotalCost() {
        return totalCost;
    }

    public static int getQuantity() {
        return items.size();
    }

    private static void setTotalCost() {
        totalCost = 0;
        for (Item item : items) {
            totalCost += item.getCost();
        }
    }

}
