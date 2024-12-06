package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:8081"})
public class GraphQLResolver {
    @Autowired
    private final ProductService productService;

    public GraphQLResolver(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public Product getProduct(@Argument Long id) {
        return productService.getProduct(id);
    }
    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }
    @MutationMapping
    public Product addProduct(@Argument Product product) {
        return productService.addProduct(product);
    }
    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument Product product) {
        return productService.updateProduct(id,product);
    }
    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        productService.deleteProduct(id);
        return true;
    }

}
