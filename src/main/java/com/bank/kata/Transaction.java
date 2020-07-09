package com.bank.kata;

import java.util.Date;

public class Transaction {
	
	Account payer; 
	Account payee; 
	double amount; 
	Date date; 
	
	public Transaction(Account payer, Account payee, double amount, Date date) {
		this.payer = payer;
		this.payee = payee; 
		this.amount = amount;
		this.date = date; 
	}

	public Account getPayer() {
		return payer;
	}

	public Account getPayee() {
		return payee;
	}

	public double getAmount() {
		return amount;
	}
	
	
}
