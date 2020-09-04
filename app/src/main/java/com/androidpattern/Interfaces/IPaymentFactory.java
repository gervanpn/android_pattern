package com.androidpattern.Interfaces;

import com.androidpattern.PaymentFactory.PaymentType;

public interface IPaymentFactory {
    void CreatePayment(PaymentType type);
}
