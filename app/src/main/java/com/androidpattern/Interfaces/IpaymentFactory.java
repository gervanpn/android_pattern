package com.androidpattern.Interfaces;

import com.androidpattern.PaymentOptions.EpaymentType;

public interface IpaymentFactory {
    void CreatePayment(EpaymentType type);


}
