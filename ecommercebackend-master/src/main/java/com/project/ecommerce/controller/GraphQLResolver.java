package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

@Controller
@CrossOrigin(origins = {"http://localhost:4200"})
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
    @MutationMapping
    public Product addProduct(@Argument Product product) {
        return productService.addProduct(product);
    }
    @MutationMapping
    public Product updateProduct(@Argument Product product) {
        return productService.updateProduct(product.getId(),product);
    }
    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        productService.deleteProduct(id);
        return true;
    }

}
