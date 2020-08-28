package com.androidpattern.Models;

import android.util.Log;
import java.util.ArrayList;

public class Cart {

    static private ArrayList<Item> items = new ArrayList<>();

    private Cart() {
    }

    public static void addItem(Item item) {
        Cart.items.add(item);
    }

    public static int getItemId(int index){
        return items.get(index).getId();
    }

    public static String getItemName(int ind) {
        return items.get(ind).getName();
    }

    public static void removeItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) items.remove(i);
        }
    }

    public static double getTotalCost() {
        double totalCost = 0;
        for (Item item: items) {
            totalCost += item.getCost();
        };
        return totalCost;
    }

    public static int getQuantity() {
        return items.size();
    }

}
