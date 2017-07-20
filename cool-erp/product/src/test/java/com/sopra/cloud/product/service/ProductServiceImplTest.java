package com.sopra.cloud.product.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sopra.cloud.product.model.Product;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testFindAllProducts() {
		List<Product> products = productService.findAll();
		assertTrue(products != null);
		assertTrue(products.size() > 0);
		assertTrue(products.get(0).getId() == 0);
	}

	@Test
	public void testFindOneProduct() {
		Product product  = productService.find(0);
		assertTrue(product != null);
		assertTrue(product.getId() == 0);
	}
}