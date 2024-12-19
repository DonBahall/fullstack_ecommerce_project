package com.project.ecommerce.service;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
public class ServiceV3 extends TaskServiceGrpc.TaskServiceImplBase{
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
        log.info("Get All Task GRPC method completed. Response: " + response);
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
                .build();
        if (responseTask.getDeadline()!= null) grpcTask = grpcTask.toBuilder().setDeadline(responseTask.getDeadline().toString()).build();
        TaskResponse response = TaskResponse.newBuilder()
                .setTask(grpcTask)
                .build();
        log.info("Get Task GRPC method completed. Response: " + response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    private com.project.ecommerce.entity.Task productToEntity(Task task){
        Date date = null;
        if(task.getDeadline() != null && !task.getDeadline().isEmpty()){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(task.getDeadline(), formatter);
            Instant instant = zonedDateTime.toInstant();
            date = Date.from(instant);
        }
        return new com.project.ecommerce.entity.Task(task.getId(), task.getTitle(), task.getCompleted(),
                date);
    }
    @Override
    public void addTask(AddTaskRequest request, StreamObserver<TaskResponse> responseObserver) {
        log.info("Add Task GRPC method called. Request: task { " + request.getTask() + "}");
        com.project.ecommerce.entity.Task savedTask = productService.addTask(productToEntity(request.getTask()));
        TaskResponse response = TaskResponse.newBuilder()
                .setTask(entityToTask(savedTask))
                .build();
        log.info("Add Task GRPC method completed. Response: " + response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    private Task entityToTask(com.project.ecommerce.entity.Task taskEntity) {
        return Task.newBuilder()
                .setId(taskEntity.getId())
                .setTitle(taskEntity.getTitle())
                .setCompleted(taskEntity.getCompleted())
                .setDeadline(taskEntity.getDeadline().toString())
                .build();
    }
    @Override
    public void updateTask(UpdateTaskRequest request, StreamObserver<TaskResponse> responseObserver) {
        log.info("Update Task GRPC method called. Request: task = " + request.getTask() + ", id = " + request.getId());
        productService.updateTask(request.getId(), productToEntity(request.getTask()));
        TaskResponse response = TaskResponse.newBuilder()
                .setTask(request.getTask())
                .build();
        log.info("Update Task GRPC method completed. Response: " + response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void deleteTask(DeleteTaskRequest request, StreamObserver<BooleanResponse> responseObserver) {
        log.info("Delete Task GRPC method called. Request: id = " + request.getId());
        productService.deleteTask(request.getId());
        responseObserver.onNext(BooleanResponse.newBuilder().setResp(true).build());
        responseObserver.onCompleted();
    }
}
