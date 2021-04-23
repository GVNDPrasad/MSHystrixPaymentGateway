package com.mszsh.paymentgateways.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/pgController")
public class PGController {

	private static final Logger log = LoggerFactory.getLogger(PGController.class);

	@GetMapping("/pay")
	@HystrixCommand(fallbackMethod = "paymentReqFallback")
	public String paymentReq() {
		log.info("Entered PGController :: paymentReq() - Actual logic(Closed Circuit)");
		if (new Random().nextInt(10) < 10) {
			throw new RuntimeException(" Random Exception");
		}

		return "Your payment successfully recieved";
	}

	public String paymentReqFallback() {
		log.info("Entered PGController :: paymentReqFallback() - Failure/Fallback logic(Open Circuit)");
		System.out.println("After 20 times same exception directly will call paymentReqFallback()");
		return "Payment Getway is down currently! Try after some time";
	}
	
	@GetMapping("/show")
	public String show() {
		return "Hi Prasad";
	}

}
