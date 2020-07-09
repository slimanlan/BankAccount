package com.bank.kata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionRecord {

	List<Transaction> TransactionRecord = new ArrayList<>(); 
	
	public Transaction doAndSaveTransaction(Account payer, Account payee, double amount) {
		
		Transfert transfert = new Transfert(payer, payee);
		transfert.transfertAmountFromPayerToPayee(amount);
		
		Transaction transaction = new Transaction(payer, payee, amount, new Date()); 
		
		TransactionRecord.add(transaction);
		
		return transaction;
		
	}

	public List<Transaction> getAllTransactionFromPayer(Account payer) {
		return TransactionRecord
				.stream()
				.filter(transaction -> transaction.getPayer().equals(payer))
				.collect(Collectors.toList()); 
	}
	
	
	public List<Transaction> getAllTransactionToPayee(Account payee) {
		return TransactionRecord
				.stream()
				.filter(transaction -> transaction.getPayee().equals(payee))
				.collect(Collectors.toList()); 
	}
}
