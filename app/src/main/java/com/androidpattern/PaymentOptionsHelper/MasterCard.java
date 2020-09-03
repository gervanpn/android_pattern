package com.androidpattern.PaymentOptionsHelper;

public class MasterCard implements PaymentOP{


    @Override
    public void pay() {
        System.out.println("payment is working");
    }
}
