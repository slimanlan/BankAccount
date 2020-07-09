package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AccountTest {
	
	@Test
	public void test_deposit_amount() {
		Account account = new Account();
		account.deposit(100);
		assertTrue(account.getAmount() == 100 ); 
	}
	
	@Test
	public void test_withdraw_amount() {
		Account account = new Account();
		account.deposit(100);
		account.withdraw(50);
		assertTrue(account.getAmount() == 50 ); 
	}
	
	@Test
	public void test_withdraw_amount_exception() {
		
		Exception exception = assertThrows(RuntimeException.class, () -> {
			Account account = new Account();
			account.deposit(100);
			account.withdraw(500);
	    });
	 
	    String expectedMessage = "Operation blocked due to insufficient funds";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	}
}
