package com.androidpattern.Models;

import com.androidpattern.Interfaces.IPaymentStrategy;

public class CreditCardStrategy implements IPaymentStrategy {
	
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	public CreditCardStrategy(String name, String ccNum, String cvv, String expiryDate){
		this.name = name;
		this.cardNumber = ccNum;
		this.cvv = cvv;
		this.dateOfExpiry = expiryDate;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount +" paid with credit card");
	}
}