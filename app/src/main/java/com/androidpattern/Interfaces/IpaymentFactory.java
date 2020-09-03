package com.androidpattern.Interfaces;

import com.androidpattern.PaymentOptionsHelper.PaymentType;

public interface IpaymentFactory {
    void CreatePayment(PaymentType type);


}
