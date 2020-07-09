package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AccountTest {
	
	
	@Test
	public void test_deposit_amount() {
		Account account = new Account();
		account.deposit(100);
		assertEquals(account.getAmount(), 100 ); 
	}
	
	@Test
	public void test_withdraw_amount() {
		Account account = new Account();
		account.deposit(100);
		account.withdraw(50);
		assertEquals(account.getAmount() , 50 ); 
	}
	
	@Test
	public void test_multipe_withdraw_amount() {
		Account account = new Account();
		account.deposit(100);
		account.withdraw(50);
		account.withdraw(20);
		assertEquals(account.getAmount() , 30 ); 
	}
}
