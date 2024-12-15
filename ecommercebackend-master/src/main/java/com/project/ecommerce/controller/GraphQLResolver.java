package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:8081"})
@Slf4j
public class GraphQLResolver {
    @Autowired
    private final ProductService productService;

    public GraphQLResolver(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public Product getProduct(@Argument Long id) {
        log.info("Get Product Graphql method called ");
        return productService.getProduct(id);
    }
    @QueryMapping
    public List<Product> getAllProducts() {
        log.info("Get All Products Graphql method called ");
        return productService.getProducts();
    }
    @MutationMapping
    public Product addProduct(@Argument Product product) {
        log.info("Add Product Graphql method called ");
        return productService.addProduct(product);
    }
    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument Product product) {
        log.info("Update Product Graphql method called ");
        return productService.updateProduct(id,product);
    }
    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        log.info("Delete Product Graphql method called ");
        productService.deleteProduct(id);
        return true;
    }

}
