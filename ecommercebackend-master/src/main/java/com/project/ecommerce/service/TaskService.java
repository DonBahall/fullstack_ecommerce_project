package com.project.ecommerce.service;

import com.project.ecommerce.entity.Task;
import com.project.ecommerce.exceptions.TaskNotFoundException;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Service
public class TaskService {
    @Getter
    List<Task> tasks = new ArrayList<>() {{
        add(new Task(1L, "Learn Vue.js",true, new Date(2024, Calendar.DECEMBER, 21)));
        add(new Task(2L, "Build a TODO App", false, new Date(2024, Calendar.DECEMBER, 22)));
    }};

    public Task getTask(Long id) {
        return tasks.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new TaskNotFoundException("Product by id " + id + " was not found."));
    }

    public Task addTask(Task task) {
        task.setId(tasks.size() + 1L);
        tasks.add(task);
        return task;
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = getTask(id);
        if(task.getTitle() != null)   existingTask.setTitle(task.getTitle());
        if(task.getCompleted() != null)    existingTask.setCompleted(task.getCompleted());
        if(task.getDeadline() != null)    existingTask.setDeadline(task.getDeadline());
        return existingTask;
    }

    public Boolean deleteTask(Long id) {
        Task task = getTask(id);
        tasks.remove(task);
        return true;
    }

    public static com.project.ecommerce.service.Task mapToProtobuf(com.project.ecommerce.entity.Task task) {
        return com.project.ecommerce.service.Task.newBuilder().setId(task.getId())
                .setTitle(task.getTitle())
                .setCompleted(task.getCompleted())
                .setDeadline(task.getDeadline().toString())
                .build();
    }
}
