package com.project.ecommerce.service;

import com.project.ecommerce.exceptions.ProductNotFoundException;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getProducts () {
        return repo.findAll();
    }

    public Product getProduct (Long id) {
        return repo.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product by id " + id + " was not found."));
    }

    public Product addProduct (Product product) {
        return repo.save(product);
    }

    public Product updateProduct (Long id, Product product) {
        Product oldProduct = getProduct(id);

        oldProduct.setTitle(product.getTitle());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setCategory(product.getCategory());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setImage(product.getImage());

        return repo.save(oldProduct);
    }

    public void deleteProduct (Long id) {
        repo.deleteById(id);
    }
}
