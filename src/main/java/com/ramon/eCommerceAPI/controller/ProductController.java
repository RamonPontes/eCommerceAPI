package com.ramon.eCommerceAPI.controller;

import com.ramon.eCommerceAPI.model.Product;
import com.ramon.eCommerceAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @PostMapping
    private ResponseEntity<?> createdProduct(@RequestBody Product productData) {
        if (productData.isAnyFieldNull()) { return ResponseEntity.status(400).body("All fields are required"); }

        return ResponseEntity.status(200).body(productService.createdProduct(productData));
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getProductWithId(@PathVariable int id) {
        if (id < 0) { return ResponseEntity.status(400).body("Invalid id");}

        Optional<Product> product = productService.getProductWithId(id);

        if (product.isEmpty()) {
            return ResponseEntity.status(404).body("Product not found");
        } else {
            return ResponseEntity.status(200).body(product);
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> editProduct(@RequestBody Product productData, @PathVariable int id) {
        if (id < 0) { return ResponseEntity.status(400).body("Invalid id"); }

        if (productData.isAnyFieldNull()) { return ResponseEntity.status(400).body("All fields are required"); }

        Optional<Product> product = productService.getProductWithId(id);

        if (product.isEmpty()) {
            return ResponseEntity.status(404).body("Product not found");
        } else {
            return ResponseEntity.status(200).body(productService.editProduct(productData, id));
        }
    }
}
