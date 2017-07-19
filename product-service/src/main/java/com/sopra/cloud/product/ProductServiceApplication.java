package com.sopra.cloud.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.sopra.cloud.invoiceserviceclient.InvoiceClient;

@EnableCircuitBreaker
@SpringBootApplication
@EnableHystrixDashboard
public class ProductServiceApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceApplication.class);

	public static void main(String[] args) {

		InvoiceClient invoiceClient = SpringApplication.run(ProductServiceApplication.class, args)
				.getBean(InvoiceClient.class);
		while (true) {
			try {
				System.out.println(invoiceClient.findAll());
			} catch (Exception e) {
				LOGGER.error("Bobo", e);
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
