package com.androidpattern.Models;

import com.androidpattern.Settings;

import java.util.ArrayList;

public class Cart {

    static private ArrayList<Item> items = new ArrayList<>();
    private Cart() { }
    public static boolean switchState;
    public static double taxRate;
    public static void addItem(Item item) {
        Cart.items.add(item);
    }

    public static ArrayList<Item> getItems() {
        return items;
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

    public static boolean getTaxSetting() {
        return switchState;
    }

    public static boolean setTaxSetting() {
        switchState = Settings.setTaxes();
        return switchState;
    }

    public static double getTaxRate() {
        return taxRate;
    }

    public static double setTaxRate() {
        taxRate = Settings.taxAmount();
        return taxRate;
    }

}
