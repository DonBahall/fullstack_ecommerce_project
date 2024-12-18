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
        log.info("Get Task GRPC method called. Request: " + id + " Responce: " + taskservice.getTask(id));
        return taskservice.getTask(id);
    }
    @QueryMapping
    public List<Task> getAllTasks() {
        log.info("Get All Tasks Graphql method called ");
        return taskservice.getTasks();
    }
    @MutationMapping
    public Task addTask(@Argument Task product) {
        log.info("Add Task GRPC method called. Request: " + product + " Responce: " + product);
        return taskservice.addTask(product);
    }
    @MutationMapping
    public Task updateTask(@Argument Long id, @Argument Task product) {
        Task task = taskservice.updateTask(id, product);
        log.info("Update Task Graphql method called. Request: task = " + product + ", id= " + id + " Responce: " + task);
        return task;
    }
    @MutationMapping
    public Boolean deleteTask(@Argument Long id) {
        log.info("Delete Task Graphql method called. Request: " + id);
        taskservice.deleteTask(id);
        return true;
    }

}
