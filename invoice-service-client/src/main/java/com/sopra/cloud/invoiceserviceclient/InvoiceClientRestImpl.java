package com.sopra.cloud.invoiceserviceclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.sopra.cloud.invoiceserviceclient.model.Invoice;

public class InvoiceClientRestImpl implements InvoiceClient {
	private String url;
	private RestTemplate restTemplate;

	public InvoiceClientRestImpl(String url, RestTemplate restTemplate) {
		this.url = url;
		this.restTemplate = restTemplate;
	}

	@Override
	public void newInvoice() {
		restTemplate.exchange(url + "/invoice", HttpMethod.POST, null, Invoice.class);
	}

	@Override
	public List<Invoice> findAll() {
		return restTemplate
				.exchange(url + "/invoice", HttpMethod.GET, null, new ParameterizedTypeReference<List<Invoice>>() {
				}).getBody();
	}
}
