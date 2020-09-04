package com.androidpattern.PaymentFactory;

import com.androidpattern.Interfaces.IPaymentOP;

public class Debit implements IPaymentOP {
    @Override
    public void pay() {
        System.out.println("debit is working");
    }

}
