package com.sopra.cloud.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.cloud.product.model.Product;
import com.sopra.cloud.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;		
	}
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product find(Integer id) {		
		return productRepository.findOne(id);
	}

}
