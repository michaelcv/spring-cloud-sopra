package com.sopra.cloud.product.controller;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import com.sopra.cloud.product.ProductServiceApplication;
import com.sopra.cloud.product.model.Product;

@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ProductServiceControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testFindAllProducts() {
		List<Product> products = restTemplate
				.exchange("/product", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
				}).getBody();
		assertTrue(products != null);
		assertTrue(products.size() > 0);
		assertTrue(products.get(0).getId() == 0);
	}

	@Test
	public void testFindOneProduct() {
		Product product = restTemplate
				.exchange("/product/0", HttpMethod.GET, null, new ParameterizedTypeReference<Product>() {
				}).getBody();
		assertTrue(product != null);
		assertTrue(product.getId() == 0);
	}
}
