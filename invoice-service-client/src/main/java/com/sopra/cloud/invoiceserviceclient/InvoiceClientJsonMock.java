package com.sopra.cloud.invoiceserviceclient;

import java.util.Arrays;
import java.util.List;

import com.sopra.cloud.invoiceserviceclient.model.Invoice;

public class InvoiceClientJsonMock implements InvoiceClient {

	@Override
	public void newInvoice() {
		// OK
	}

	@Override
	public List<Invoice> findAll() {
		return Arrays.asList();
	}
}
