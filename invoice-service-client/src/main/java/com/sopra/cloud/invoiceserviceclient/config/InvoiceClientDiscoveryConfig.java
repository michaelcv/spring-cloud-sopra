package com.sopra.cloud.invoiceserviceclient.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@ConditionalOnProperty(name = "invoice.service.mock", havingValue = "false", matchIfMissing = true)
public class InvoiceClientDiscoveryConfig {

}
