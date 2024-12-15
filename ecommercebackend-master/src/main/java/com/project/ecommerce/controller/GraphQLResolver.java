package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Task;
import com.project.ecommerce.service.TaskService;
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
    private final TaskService taskservice;

    public GraphQLResolver(TaskService taskservice) {
        this.taskservice = taskservice;
    }

    @QueryMapping
    public Task getTask(@Argument Long id) {
        log.info("Get Product Graphql method called ");
        return taskservice.getTask(id);
    }
    @QueryMapping
    public List<Task> getAllTasks() {
        log.info("Get All Products Graphql method called ");
        return taskservice.getTasks();
    }
    @MutationMapping
    public Task addTask(@Argument Task product) {
        log.info("Add Product Graphql method called ");
        return taskservice.addTask(product);
    }
    @MutationMapping
    public Task updateTask(@Argument Long id, @Argument Task product) {
        log.info("Update Product Graphql method called ");
        return taskservice.updateTask(id,product);
    }
    @MutationMapping
    public Boolean deleteTask(@Argument Long id) {
        log.info("Delete Product Graphql method called ");
        taskservice.deleteTask(id);
        return true;
    }

}
