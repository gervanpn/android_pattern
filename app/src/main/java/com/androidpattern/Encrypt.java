package com.androidpattern;

import com.androidpattern.Interfaces.Ipayment;

public class Encrypt implements Ipayment {

    private String payment;

    public Encrypt(String payment) {
        this.payment = payment;
        
    }

    public Encrypt(){}

    @Override
    public void creditText() {
        encrypt(payment);
    }

   public String encrypt( String CC){
        return "ENCRYPT";
    }


}
