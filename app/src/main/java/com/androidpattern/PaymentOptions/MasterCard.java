package com.androidpattern.PaymentOptions;

public class MasterCard implements PaymentOP{


    @Override
    public void pay() {
        System.out.println("payment is working");
    }
}
