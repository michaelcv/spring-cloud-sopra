package com.sopra.cloud.product.service;

import java.util.List;

import com.sopra.cloud.product.model.Product;

public interface ProductService {
	public List<Product> findAll();

	public Product find(Integer id);
}
