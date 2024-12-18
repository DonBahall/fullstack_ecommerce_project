package com.project.ecommerce.service;

import com.project.ecommerce.entity.Task;
import com.project.ecommerce.exceptions.TaskNotFoundException;
import com.project.ecommerce.repository.TaskRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if(task.getTitle() != null)   existingTask.setTitle(task.getTitle());
        if(task.getCompleted() != null)    existingTask.setCompleted(task.getCompleted());
        if(task.getDeadline() != null)    existingTask.setDeadline(task.getDeadline());
        return taskRepository.save(existingTask);
    }

    public Boolean deleteTask(Long id) {
        taskRepository.deleteById(id);
        return true;
    }

    public static com.project.ecommerce.service.Task mapToProtobuf(com.project.ecommerce.entity.Task task) {
        boolean isDeadline = task.getDeadline() != null;
        return com.project.ecommerce.service.Task.newBuilder().setId(task.getId())
                .setTitle(task.getTitle())
                .setCompleted(task.getCompleted())
                .setDeadline(isDeadline ? task.getDeadline().toString() : "")
                .build();
    }
}
