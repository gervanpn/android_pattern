package com.androidpattern.Models;

import com.androidpattern.Interfaces.IPaymentStrategy;

public class PaypalStrategy implements IPaymentStrategy {
	
	private String _email;
	private String _password;
	
	public PaypalStrategy(String email, String pwd){
		this._email = email;
		this._password = pwd;
	}
	
	@Override
	public void pay(int amount) {
	}
}