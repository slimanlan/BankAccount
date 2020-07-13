package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransfertTest {
	
	Account payer; 
	Account payee;
	Transfert transfert; 
	
    @BeforeEach
	public void setup() {
		payer = new Account(); 
		payee = new Account();
		transfert = new Transfert(payer, payee);
		payer.deposit(500);
	}
	
	
	@Test
	public void test_transfert_payer_amount() {
		transfert.transfertAmountFromPayerToPayee(60);
		assertEquals(payer.getAmount(), 440);
	}
	
	@Test
	public void test_transfert_payee_amount() {
		transfert.transfertAmountFromPayerToPayee(60);
		assertEquals(payee.getAmount(), 60);
	}
	
	@Test
	public void test_multipe_transfert_from_payer() {
		transfert.transfertAmountFromPayerToPayee(60);
		transfert.transfertAmountFromPayerToPayee(30);
		assertEquals(payer.getAmount(), 410);
	}
	
	
	@Test
	public void test_multipe_transfert_to_payee() {
		transfert.transfertAmountFromPayerToPayee(100);
		transfert.transfertAmountFromPayerToPayee(40);
		assertEquals(payee.getAmount(), 140);
	}
}
