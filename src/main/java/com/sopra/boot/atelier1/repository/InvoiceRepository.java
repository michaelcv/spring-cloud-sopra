package com.sopra.boot.atelier1.repository;

import java.util.List;

import com.sopra.boot.atelier1.model.Invoice;

public interface InvoiceRepository {
	List<Invoice> findAll();
	
	void save(Invoice invoice);
}
