package com.sopra.cloud.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.cloud.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
