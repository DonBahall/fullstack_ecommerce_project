package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UCPController {
    private final ProductService productService;

    public UCPController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/v1/products")
    public ResponseEntity<List<Product>> getProducts () {
        log.info("Get All Product Rest Api method called on url: /v1/products" );
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/v1/products/{id}")
    public ResponseEntity<Product> getProduct (@PathVariable("id") Long id) {
        log.info("Get Product Rest Api method called on url: /v1/products/{id}" );
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @PostMapping("/v1/products")
    public ResponseEntity<Product> addProduct (@RequestBody Product product) {
        log.info("Add Product Rest Api method called on url: /v1/products" );
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @PutMapping("/v1/products/{id}")
    public ResponseEntity<Product> updateProduct (@PathVariable("id") Long id, @RequestBody Product product) {
        log.info("Update Product Rest Api method called on url: /v1/products/{id}" );
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/v1/products/{id}")
    public ResponseEntity<?> deleteProduct (@PathVariable("id") Long id) {
        log.info("Delete Product Rest Api method called on url: /v1/products/{id}" );
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
