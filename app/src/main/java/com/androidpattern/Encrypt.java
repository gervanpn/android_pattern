package com.androidpattern;

public class Encrypt implements Payment{

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
        return "@#$%$&*&+#@!~";
    }


}
