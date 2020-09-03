package com.androidpattern.PaymentFactory;

import com.androidpattern.Interfaces.IpaymentOP;

public class MasterCard implements IpaymentOP {


    @Override
    public void pay() {
        System.out.println("payment is working");
    }
}
