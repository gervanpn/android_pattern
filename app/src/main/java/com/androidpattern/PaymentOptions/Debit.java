package com.androidpattern.PaymentOptions;

public class Debit implements PaymentOP {
    @Override
    public void pay() {
        System.out.println("debit is working");
    }

}
