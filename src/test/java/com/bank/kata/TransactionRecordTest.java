package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionRecordTest {
	
	TransactionRecord transactionRecord;
	Account payer; 
	Account payee; 
	
    @BeforeEach
	public void setup() {
		transactionRecord = new TransactionRecord();
		payer = new Account(); 
		payee = new Account();
		payer.deposit(1000);
	}
	
	@Test
	public void test_save_transaction_payer_amount() {
		
		Transaction transaction = transactionRecord.saveTransaction(payer, payee, 50); 
		assertEquals(transaction.getPayer().getAmount() , 950); 
		
	}
	
	@Test
	public void test_save_transaction_payee_amount() {
		
		Transaction transaction = transactionRecord.saveTransaction(payer, payee, 50); 
		assertEquals(transaction.getPayee().getAmount() , 50);
		
	}
	
	@Test
	public void test_save_transaction_amount() {
		
		Transaction transaction = transactionRecord.saveTransaction(payer, payee, 50); 
		assertEquals(transaction.getAmount() , 50);
		
	}
	
	@Test
	public void test_save_transaction_from_payer_to_payee() {
		
		Transaction transaction = transactionRecord.saveTransaction(payer, payee, 50); 
		assertTrue(transaction.getPayer().equals(payer));
		assertTrue(transaction.getPayee().equals(payee));
		
	}
	
	@Test
	public void test_get_all_transaction_from_payer() {
		
		transactionRecord.saveTransaction(payer, payee, 50); 
		transactionRecord.saveTransaction(payer, payee, 150); 
		transactionRecord.saveTransaction(payer, payee, 250); 
		
		List<Transaction> transactionRecordFromPayer = transactionRecord.getAllTransactionFromPayer(payer); 
		
		assertEquals(transactionRecordFromPayer.size() , 3);
		transactionRecordFromPayer.forEach(transaction -> {
			assertTrue(transaction.getPayer().equals(payer));
		});
		
	}
	
	@Test
	public void test_get_all_transaction_to_payee() {
		
		transactionRecord.saveTransaction(payer, payee, 100); 
		transactionRecord.saveTransaction(payer, payee, 50); 
		transactionRecord.saveTransaction(payer, payee, 120); 
		transactionRecord.saveTransaction(payer, payee, 130); 
		
		List<Transaction> transactionRecordToPayee = transactionRecord.getAllTransactionToPayee(payee); 
		
		assertEquals(transactionRecordToPayee.size() , 4);
		transactionRecordToPayee.forEach(transaction -> {
			assertTrue(transaction.getPayee().equals(payee));
		});
	
	}
}
