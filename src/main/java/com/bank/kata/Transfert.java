package com.bank.kata;

public class Transfert {
	
	Account payer; 
	Account payee; 
	
	public Transfert(Account payer, Account payee) {
		this.payer = payer; 
		this.payee = payee;
	}

	public void transfertAmountFromPayerToPayee(double amount) {
		payer.withdraw(amount);
		payee.deposit(amount);
	}

}
