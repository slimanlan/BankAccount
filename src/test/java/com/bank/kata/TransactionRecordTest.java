package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TransactionRecordTest {
	
	@Test
	public void test_do_and_save_transaction() {
		
		Account payer = new Account(); 
		Account payee = new Account();
		payer.deposit(1000);
		TransactionRecord transactionRecord = new TransactionRecord(); 
		
		Transaction transaction = transactionRecord.doAndSaveTransaction(payer, payee, 50); 
		
		
		assertEquals(payer.getAmount() , 950); 
		assertEquals(payee.getAmount() , 50);
		assertTrue(transaction.getPayer().equals(payer));
		assertTrue(transaction.getPayee().equals(payee));
		assertEquals(transaction.getAmount() , 50);
		
	}
	
	@Test
	public void test_get_all_transaction_from_payer() {
		
		TransactionRecord transactionRecord = new TransactionRecord();

		Account payer = new Account(); 
		payer.deposit(10000);
		
		Account payee1 = new Account();		
		transactionRecord.doAndSaveTransaction(payer, payee1, 50); 
		
		Account payee2 = new Account();		
		transactionRecord.doAndSaveTransaction(payer, payee2, 150); 
		
		Account payee3 = new Account();		
		transactionRecord.doAndSaveTransaction(payer, payee3, 250); 
		
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
		transactionRecord.doAndSaveTransaction(payer1, payee, 100); 
		
		Account payer2 = new Account();		
		payer2.deposit(1000);
		transactionRecord.doAndSaveTransaction(payer2, payee, 50); 
		
		Account payer3 = new Account();		
		payer3.deposit(1000);
		transactionRecord.doAndSaveTransaction(payer3, payee, 120); 
		
		Account payer4 = new Account();		
		payer4.deposit(1000);
		transactionRecord.doAndSaveTransaction(payer4, payee, 130); 
		
		List<Transaction> transactionRecordToPayee = transactionRecord.getAllTransactionToPayee(payee); 
		
		assertEquals(transactionRecordToPayee.size() , 4);

		transactionRecordToPayee.forEach(transaction -> {
			assertTrue(transaction.getPayee().equals(payee));
		});
	
	}
}
