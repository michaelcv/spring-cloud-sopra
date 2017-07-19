package com.sopra.cloud.superclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sopra.cloud.invoiceserviceclient.InvoiceClient;

@SpringBootApplication
public class SuperClientApplication {

	public static void main(String[] args) {
		InvoiceClient invoiceClient = SpringApplication.run(SuperClientApplication.class, args)
				.getBean(InvoiceClient.class);

		System.out.println(invoiceClient.findAll());
	}
}
