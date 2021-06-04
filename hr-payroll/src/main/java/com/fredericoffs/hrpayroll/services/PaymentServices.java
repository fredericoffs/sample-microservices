package com.fredericoffs.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredericoffs.hrpayroll.entities.Payment;
import com.fredericoffs.hrpayroll.entities.Worker;
import com.fredericoffs.hrpayroll.feignclients.WorkerFeignClients;

@Service
public class PaymentServices {

	@Autowired
	private WorkerFeignClients workerFeignClient;

	public Payment getPayment(Long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
