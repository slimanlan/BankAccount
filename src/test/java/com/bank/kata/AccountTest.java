package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
	
	Account account; 
	
	@BeforeEach
	public void setup() {
		account = new Account();
		account.deposit(100);
	}
	
	@Test
	public void test_deposit_amount() {
		assertEquals(account.getAmount(), 100 ); 
	}
	
	@Test
	public void test_withdraw_amount() {
		account.withdraw(50);
		assertEquals(account.getAmount() , 50 ); 
	}
	
	@Test
	public void test_multipe_withdraw_amount() {
		account.withdraw(50);
		account.withdraw(20);
		assertEquals(account.getAmount() , 30 ); 
	}
}
