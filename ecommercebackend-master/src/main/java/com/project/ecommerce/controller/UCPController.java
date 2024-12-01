package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.entity.User;
import com.project.ecommerce.service.ProductService;
import com.project.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UCPController {
    private final UserService userService;
    private final ProductService productService;

    public UCPController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }


    @GetMapping("/v1/users")
    public ResponseEntity<List<User>> getUsers () {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/v1/users/{id}")
    public ResponseEntity<User> getUser (@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PutMapping("/v1/users/{id}")
    public ResponseEntity<User> updateUser (@PathVariable("id") Long id, @RequestBody Map<String, Object> user) {
        User newUser = new User(
                (String) user.get("username"),
                (String) user.get("password"),
                (String) user.get("email"),
                (String) user.get("name"),
                (String) user.get("address"),
                (String) user.get("phone")
        );

        return new ResponseEntity<>(userService.updateUser(id, newUser), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/v1/users/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/v1/products")
    public ResponseEntity<List<Product>> getProducts () {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/v1/products/{id}")
    public ResponseEntity<Product> getProduct (@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @PostMapping("/v1/products")
    public ResponseEntity<Product> addProduct (@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @PutMapping("/v1/products/{id}")
    public ResponseEntity<Product> updateProduct (@PathVariable("id") Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/v1/products/{id}")
    public ResponseEntity<?> deleteProduct (@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
