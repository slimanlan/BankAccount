package com.bank.kata;

public class Account {
	
	double amount = 0; 
	
	public void deposit(double amount) {
		this.amount += amount;
	}

	public double getAmount() {
		return this.amount;
	}

	public void withdraw(double d) {
		if (amount >= d) amount -= d;
		else throw new RuntimeException("Operation blocked due to insufficient funds");
	}

}
