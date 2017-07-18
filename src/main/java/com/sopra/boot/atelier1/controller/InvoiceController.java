package com.sopra.boot.atelier1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.boot.atelier1.model.Invoice;
import com.sopra.boot.atelier1.repository.InvoiceRepository;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	private InvoiceRepository invoiceRepository;

	public InvoiceController(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	@GetMapping
	@ResponseBody
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

}
