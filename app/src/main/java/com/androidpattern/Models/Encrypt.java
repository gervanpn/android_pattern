package com.androidpattern.Models;

import com.androidpattern.Interfaces.IPayment;

public class Encrypt implements IPayment {

    private String _encryptPayment;

    public Encrypt(String payment) {
        this._encryptPayment = payment;
    }

    public Encrypt() {
    }

    @Override
    public void creditText() {
        encrypt(_encryptPayment);
    }

    public String encrypt(String creditCard) {
        return "ENCRYPT";
    }
}
