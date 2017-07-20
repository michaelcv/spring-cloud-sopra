package com.sopra.coolerp.sale.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.coolerp.sale.model.Sale;
import com.sopra.coolerp.sale.service.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {
	
	private Logger LOGGER = LoggerFactory.getLogger(SaleController.class);
	
	private SaleService saleService;
	
	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@PostMapping
	public void newSale(@RequestParam("productId") long productId) {
		this.saleService.save(new Sale(0, productId, new Date(), "PAID"));
		LOGGER.info("Sold product " + productId);
	}
}
