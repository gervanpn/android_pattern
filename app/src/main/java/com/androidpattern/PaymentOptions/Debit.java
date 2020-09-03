package com.androidpattern.PaymentOptions;

import com.androidpattern.Interfaces.IpaymentOP;

public class Debit implements IpaymentOP {
    @Override
    public void pay() {
        System.out.println("debit is working");
    }

}
