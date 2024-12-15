package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Task;
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

    @GetMapping("/v1/tasks")
    public ResponseEntity<List<Task>> getTasks () {
        log.info("Get All Task Rest Api method called on url: /v1/products" );
        return new ResponseEntity<>(productService.getTasks(), HttpStatus.OK);
    }

    @GetMapping("/v1/tasks/{id}")
    public ResponseEntity<Task> getTask (@PathVariable("id") Long id) {
        log.info("Get Task Rest Api method called on url: /v1/products/{id}" );
        return new ResponseEntity<>(productService.getTask(id), HttpStatus.OK);
    }

    @PostMapping("/v1/tasks")
    public ResponseEntity<Task> addTask (@RequestBody Task task) {
        log.info("Add Task Rest Api method called on url: /v1/products" );
        return new ResponseEntity<>(productService.addTask(task), HttpStatus.OK);
    }

    @PatchMapping("/v1/tasks/{id}")
    public ResponseEntity<Task> updateTask (@PathVariable("id") Long id, @RequestBody Task task) {
        log.info("Update Task Rest Api method called on url: /v1/products/{id}" );
        return new ResponseEntity<>(productService.updateTask(id, task), HttpStatus.OK);
    }

    @DeleteMapping("/v1/tasks/{id}")
    public ResponseEntity<?> deleteTask (@PathVariable("id") Long id) {
        log.info("Delete Task Rest Api method called on url: /v1/products/{id}" );
        productService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
