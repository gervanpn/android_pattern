package com.androidpattern.Models;

import com.androidpattern.Interfaces.IpaymentStrategy;

public class CreditCardStrategy implements IpaymentStrategy {
	
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
		this.name = nm;
		this.cardNumber = ccNum;
		this.cvv = cvv;
		this.dateOfExpiry = expiryDate;
	}
	@Override
	public void pay(int amount) {
		System.out.println(amount +" paid with credit card");
	}
	
}