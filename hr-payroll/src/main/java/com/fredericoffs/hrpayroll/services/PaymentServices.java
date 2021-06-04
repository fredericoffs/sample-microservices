package com.fredericoffs.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.fredericoffs.hrpayroll.entities.Payment;

@Service
public class PaymentServices {

	public Payment getPayment(Long workerId, int days) {
		// mockado
		return new Payment("Fred", 100.00, days);
	}
}
