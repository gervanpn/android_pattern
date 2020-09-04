package com.androidpattern.PaymentFactory;

import com.androidpattern.Interfaces.IPaymentOP;

public class MasterCard implements IPaymentOP {

    @Override
    public void pay() {
        System.out.println("payment is working");
    }
}
