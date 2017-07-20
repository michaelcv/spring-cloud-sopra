package com.sopra.cloud.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.cloud.product.model.Product;
import com.sopra.cloud.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductServiceController {
	private ProductService productService;

	public ProductServiceController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	@ResponseBody
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping(path="/{id}")
	@ResponseBody
	public Product find(@PathVariable Integer id) {
		return productService.find(id);
	}
}
