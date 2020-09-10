package com.demo.brainwaive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.brainwaive.model.Customer;
import com.demo.brainwaive.model.GoldLoanPayVO;
import com.demo.brainwaive.service.PaymentService;

@RestController
@EnableAutoConfiguration
public class InterestPayment {
	
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/interest")
	public Customer getInterest(){
		
		GoldLoanPayVO goldLoanPay = new GoldLoanPayVO();
		goldLoanPay.setAmountDue(10);
		goldLoanPay.setLoanNumber(123);
		Customer customer=paymentService.doPayment(goldLoanPay);
		return customer;
	}
	
	@PostMapping("/interestpay")
	public Customer payInterest(@RequestBody GoldLoanPayVO goldLoanPay){
		System.out.println("payInterest!!\n");
		System.out.println("customer id : "+ goldLoanPay.getLoanNumber());
		Customer customer = null;
		if(null != goldLoanPay && goldLoanPay.getLoanNumber() > 0){
			customer=paymentService.doPayment(goldLoanPay);
		}
		return customer;
	}

}
