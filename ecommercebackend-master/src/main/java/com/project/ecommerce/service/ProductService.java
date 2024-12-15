package com.project.ecommerce.service;

import com.project.ecommerce.exceptions.ProductNotFoundException;
import com.project.ecommerce.entity.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Service
public class ProductService {
    List<Product> products = new ArrayList<>() {{
        add(new Product(1L, "Laptop", "Gaming laptop", 1200, "Electronics", new Date()));
        add(new Product(2L, "Headphones", "Noise-cancelling headphones", 200, "Accessories", new Date()));
    }};

    public Product getProduct(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ProductNotFoundException("Product by id " + id + " was not found."));
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProduct(id);
        if(product.getTitle() != null)   existingProduct.setTitle(product.getTitle());
        if(product.getDescription() != null)    existingProduct.setDescription(product.getDescription());
        if(product.getCategory() != null)    existingProduct.setCategory(product.getCategory());
        if(product.getPrice() != null)    existingProduct.setPrice(product.getPrice());
        return existingProduct;
    }

    public boolean deleteProduct(Long id) {
        Product product = getProduct(id);
        products.remove(product);
        return true;
    }
}
