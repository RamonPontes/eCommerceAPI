package com.ramon.eCommerceAPI.repository;

import com.ramon.eCommerceAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
