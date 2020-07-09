package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		assertEquals(payer.getAmount(), 440);
		assertEquals(payee.getAmount(), 60);
	}
	
	@Test
	public void test_multipe_transfert_from_payer() {
		Account payer = new Account();
		payer.deposit(500);
		
		Account payee1 = new Account();
		Account payee2 = new Account();
		
		Transfert transfert1 = new Transfert(payer, payee1);
		transfert1.transfertAmountFromPayerToPayee(60);
		
		Transfert transfert2 = new Transfert(payer, payee2);
		transfert2.transfertAmountFromPayerToPayee(30);
	
		assertEquals(payer.getAmount(), 410);
		assertEquals(payee1.getAmount(), 60);
		assertEquals(payee2.getAmount(), 30);
	}
	
	
	@Test
	public void test_multipe_transfert_to_payee() {
		Account payer1 = new Account();
		payer1.deposit(500);
		
		Account payer2 = new Account();
		payer2.deposit(400);
		
		Account payee = new Account();
		
		Transfert transfert1 = new Transfert(payer1, payee);
		transfert1.transfertAmountFromPayerToPayee(100);
		
		Transfert transfert2 = new Transfert(payer2, payee);
		transfert2.transfertAmountFromPayerToPayee(40);
	
		assertEquals(payer1.getAmount(), 400);
		assertEquals(payer2.getAmount(), 360);
		assertEquals(payee.getAmount(), 140);
	}
	
}
