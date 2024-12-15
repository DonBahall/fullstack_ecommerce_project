package com.project.ecommerce.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
@Slf4j
public class TaskServiceGRPCs extends TaskServiceGrpc.TaskServiceImplBase{
    @Autowired
    private TaskService productService;

    @Override
    public void getAllTasks(GetAllTasksRequest request, StreamObserver<GetAllTasksResponse> responseObserver) {
        List<com.project.ecommerce.entity.Task> productList = productService.getTasks();
        List<Task> protobufTasks = productList.stream()
                .map(TaskService::mapToProtobuf)
                .collect(Collectors.toList());

        GetAllTasksResponse response = GetAllTasksResponse.newBuilder()
                .addAllTasks(protobufTasks)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getTask(GetTaskRequest request, StreamObserver<TaskResponse> responseObserver) {
        log.info("Get Task GRPC method called" );
        com.project.ecommerce.entity.Task responseTask = productService.getTask(request.getId());

        Task grpcTask = Task.newBuilder()
                .setId(responseTask.getId())
                .setTitle(responseTask.getTitle())
                .setCompleted(responseTask.getCompleted())
                .setDeadline(responseTask.getDeadline().toString())
                .build();

        TaskResponse response = TaskResponse.newBuilder()
                .setTask(grpcTask)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    private com.project.ecommerce.entity.Task productToEntity(Task task){
        return new com.project.ecommerce.entity.Task(task.getId(), task.getTitle(), task.getCompleted(),
                Date.from(Instant.now()));
    }

    @Override
    public void addTask(AddTaskRequest request, StreamObserver<TaskResponse> responseObserver) {
        log.info("Add Task GRPC method called ");
        productService.addTask(productToEntity(request.getTask()));

        TaskResponse response = TaskResponse.newBuilder()
                .setTask(request.getTask())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void updateTask(UpdateTaskRequest request, StreamObserver<TaskResponse> responseObserver) {
        log.info("Update Task GRPC method called ");
        productService.updateTask(request.getId(), productToEntity(request.getTask()));

       TaskResponse response = TaskResponse.newBuilder()
                .setTask(request.getTask())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteTask(DeleteTaskRequest request, StreamObserver<BooleanResponse> responseObserver) {
        log.info("Delete Task GRPC method called ");
        productService.deleteTask(request.getId());

        responseObserver.onNext(BooleanResponse.newBuilder().setResp(true).build());
        responseObserver.onCompleted();
    }
}
