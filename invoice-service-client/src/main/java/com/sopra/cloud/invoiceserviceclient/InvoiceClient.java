package com.sopra.cloud.invoiceserviceclient;

import java.util.List;

import com.sopra.cloud.invoiceserviceclient.model.Invoice;

public interface InvoiceClient {
	void newInvoice();

	List<Invoice> findAll();
}
