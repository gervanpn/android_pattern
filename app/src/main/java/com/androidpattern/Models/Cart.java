package com.androidpattern.Models;

public class Cart {

   static double total;
   static int quantity;

    public static double getTotal() {
        return total;
    }

    public static int getQuantity() {
        return quantity;
    }

    public static void setQuantity(int quantity) {
        Cart.quantity = quantity;
    }

    public static void setTotal(double total) {
        Cart.total = total;
    }

    public Cart(double total) {
        this.total = total;
    }
}
