package com.mszsh.paymentgateways;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class MszshPaymentGatewaysApplication {
    
	private static final Logger log = LoggerFactory.getLogger(MszshPaymentGatewaysApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MszshPaymentGatewaysApplication.class, args);
		
		log.info("Hystrix URL: http://localhost:1601/PaymentsGateway-MS/hystrix");
		
		log.info("Hystrix URL: http://localhost:1601/PaymentsGateway-MS/actuator/hystrix.stream");
		
		/**
		 *  URL's List to execute:
		 *  Zipkin URL: http://localhost:9411/zipkin/
		 *  Application URL: http://localhost:1601/PaymentsGateway-MS/pgController/pay
		 *  Hystrix URL : http://localhost:1601/PaymentsGateway-MS/hystrix
		 *  Hystrix Dashboard URL: http://localhost:1601/PaymentsGateway-MS/actuator/hystrix.stream
		 */
	}

}
