package com.project.ecommerce.service;

import com.project.ecommerce.entity.Task;
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
    @Getter
    List<Task> tasks = new ArrayList<>() {{
        add(new Task(1L, "Learn Vue.js", true));
        add(new Task(2L, "Build a TODO App", false));
    }};


    public Task getTask(Long id) {
        return tasks.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ProductNotFoundException("Product by id " + id + " was not found."));
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = getTask(id);
        if(task.getTitle() != null)   existingTask.setTitle(task.getTitle());
        if(task.getCompleted() != null)    existingTask.setCompleted(task.getCompleted());
        return existingTask;
    }

    public Boolean deleteTask(Long id) {
        Task task = getTask(id);
        tasks.remove(task);
        return true;
    }

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
    public static com.project.ecommerce.service.Product mapToProtobuf(com.project.ecommerce.entity.Product entityProduct) {
        return com.project.ecommerce.service.Product.newBuilder()
                .setId(entityProduct.getId())
                .setTitle(entityProduct.getTitle())
                .setDescription(entityProduct.getDescription())
                .setPrice(entityProduct.getPrice())
                .setCategory(entityProduct.getCategory())
                .setAddedOn(entityProduct.getAddedOn().toString())
                .build();
    }
}
