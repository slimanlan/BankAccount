package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TransactionRecordTest {
	
	@Test
	public void test_save_transaction_payer_amount() {
		
		Account payer = new Account(); 
		Account payee = new Account();
		payer.deposit(1000);
		TransactionRecord transactionRecord = new TransactionRecord(); 
		
		Transaction transaction = transactionRecord.saveTransaction(payer, payee, 50); 
		
		assertEquals(transaction.getPayer().getAmount() , 950); 
		
	}
	
	@Test
	public void test_save_transaction_payee_amount() {
		
		Account payer = new Account(); 
		Account payee = new Account();
		payer.deposit(1000);
		TransactionRecord transactionRecord = new TransactionRecord(); 
		
		Transaction transaction = transactionRecord.saveTransaction(payer, payee, 50); 
		 
		assertEquals(transaction.getPayee().getAmount() , 50);
		
	}
	
	@Test
	public void test_save_transaction_amount() {
		
		Account payer = new Account(); 
		Account payee = new Account();
		payer.deposit(1000);
		TransactionRecord transactionRecord = new TransactionRecord(); 
		
		Transaction transaction = transactionRecord.saveTransaction(payer, payee, 50); 
		
		assertEquals(transaction.getAmount() , 50);
		
	}
	
	@Test
	public void test_save_transaction_from_payer_to_payee() {
		
		Account payer = new Account(); 
		Account payee = new Account();
		payer.deposit(1000);
		TransactionRecord transactionRecord = new TransactionRecord(); 
		
		Transaction transaction = transactionRecord.saveTransaction(payer, payee, 50); 
		
		assertTrue(transaction.getPayer().equals(payer));
		assertTrue(transaction.getPayee().equals(payee));
		
	}
	
	@Test
	public void test_get_all_transaction_from_payer() {
		
		TransactionRecord transactionRecord = new TransactionRecord();

		Account payer = new Account(); 
		payer.deposit(10000);
		
		Account payee1 = new Account();		
		transactionRecord.saveTransaction(payer, payee1, 50); 
		
		Account payee2 = new Account();		
		transactionRecord.saveTransaction(payer, payee2, 150); 
		
		Account payee3 = new Account();		
		transactionRecord.saveTransaction(payer, payee3, 250); 
		
		List<Transaction> transactionRecordFromPayer = transactionRecord.getAllTransactionFromPayer(payer); 
		
		assertEquals(transactionRecordFromPayer.size() , 3);

		transactionRecordFromPayer.forEach(transaction -> {
			assertTrue(transaction.getPayer().equals(payer));
		});
	}
	
	@Test
	public void test_get_all_transaction_to_payee() {
		
		TransactionRecord transactionRecord = new TransactionRecord();

		Account payee = new Account();
		
		Account payer1 = new Account();		
		payer1.deposit(1000);
		transactionRecord.saveTransaction(payer1, payee, 100); 
		
		Account payer2 = new Account();		
		payer2.deposit(1000);
		transactionRecord.saveTransaction(payer2, payee, 50); 
		
		Account payer3 = new Account();		
		payer3.deposit(1000);
		transactionRecord.saveTransaction(payer3, payee, 120); 
		
		Account payer4 = new Account();		
		payer4.deposit(1000);
		transactionRecord.saveTransaction(payer4, payee, 130); 
		
		List<Transaction> transactionRecordToPayee = transactionRecord.getAllTransactionToPayee(payee); 
		
		assertEquals(transactionRecordToPayee.size() , 4);
		transactionRecordToPayee.forEach(transaction -> {
			assertTrue(transaction.getPayee().equals(payee));
		});
	
	}
}
