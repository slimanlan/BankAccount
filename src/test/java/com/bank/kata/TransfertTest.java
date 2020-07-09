package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TransfertTest {
	
	@Test
	public void test_transfert_from_payer_to_payee() {
		Account payer = new Account();
		payer.deposit(500);
		Account payee = new Account();
	
		Transfert transfert = new Transfert(payer, payee);
		transfert.transfertAmountFromPayerToPayee(60);
		assertTrue(payer.getAmount() == 440);
		assertTrue(payee.getAmount() == 60);
	}
	
	@Test
	public void test_transfert_from_payer_to_payee_exception() {
		
		Exception exception = assertThrows(RuntimeException.class, () -> {
			Account payer = new Account();
			payer.deposit(500);
			Account payee = new Account();
			Transfert transfert = new Transfert(payer, payee);
			transfert.transfertAmountFromPayerToPayee(600);
	    });
	 
	    String expectedMessage = "Operation blocked due to insufficient funds";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
		
	}
}
