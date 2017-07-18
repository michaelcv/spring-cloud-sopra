package com.sopra.boot.atelier1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.boot.atelier1.model.Invoice;
import com.sopra.boot.atelier1.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	private InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@GetMapping
	@ResponseBody
	public List<Invoice> findAll() {
		return invoiceService.findAll();
	}

}
