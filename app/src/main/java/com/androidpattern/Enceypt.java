package com.androidpattern;

public class Enceypt  implements Payment{

    private String payment;

    public Enceypt(String payment) {
        this.payment = payment;
    }

    public Enceypt(){}

    @Override
    public void creditText() {
        encrypt(payment);
    }

   public String encrypt( String CC){
        return "@#$%$&*&+#@!~";
    }


}
