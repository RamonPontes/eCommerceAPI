package com.ramon.eCommerceAPI.service;

import com.ramon.eCommerceAPI.model.Product;
import com.ramon.eCommerceAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductWithId(int id) {
        return productRepository.findById(id);
    }

    public Product createdProduct(Product product) {
        return productRepository.save(product);
    }
}
