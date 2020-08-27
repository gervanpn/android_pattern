package com.androidpattern.Models;

public class Cart {

   static double total;

    public static double getTotal() {
        return total;
    }

    public static void setTotal(double total) {
        Cart.total = total;
    }

    public Cart(double total) {
        this.total = total;
    }
}
