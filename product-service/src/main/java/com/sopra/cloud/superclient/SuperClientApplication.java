package com.sopra.cloud.superclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootApplication
public class SuperClientApplication {

	public static void main(String[] args) {
		DiscoveryClient discoveryClient = SpringApplication.run(SuperClientApplication.class, args)
				.getBean(DiscoveryClient.class);

		System.out.println(discoveryClient.getServices());
	}
}
