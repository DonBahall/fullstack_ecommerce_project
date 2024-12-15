package com.project.ecommerce.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: ProductServiceGRPC.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TaskServiceGrpc {

  private TaskServiceGrpc() {}

  public static final String SERVICE_NAME = "net.devh.boot.grpc.example.TaskService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GetTaskRequest,
      TaskResponse> getGetTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTask",
      requestType = GetTaskRequest.class,
      responseType = TaskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetTaskRequest,
      TaskResponse> getGetTaskMethod() {
    io.grpc.MethodDescriptor<GetTaskRequest, TaskResponse> getGetTaskMethod;
    if ((getGetTaskMethod = TaskServiceGrpc.getGetTaskMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getGetTaskMethod = TaskServiceGrpc.getGetTaskMethod) == null) {
          TaskServiceGrpc.getGetTaskMethod = getGetTaskMethod =
              io.grpc.MethodDescriptor.<GetTaskRequest, TaskResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TaskResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TaskServiceMethodDescriptorSupplier("GetTask"))
              .build();
        }
      }
    }
    return getGetTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AddTaskRequest,
      TaskResponse> getAddTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddTask",
      requestType = AddTaskRequest.class,
      responseType = TaskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AddTaskRequest,
      TaskResponse> getAddTaskMethod() {
    io.grpc.MethodDescriptor<AddTaskRequest, TaskResponse> getAddTaskMethod;
    if ((getAddTaskMethod = TaskServiceGrpc.getAddTaskMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getAddTaskMethod = TaskServiceGrpc.getAddTaskMethod) == null) {
          TaskServiceGrpc.getAddTaskMethod = getAddTaskMethod =
              io.grpc.MethodDescriptor.<AddTaskRequest, TaskResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AddTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TaskResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TaskServiceMethodDescriptorSupplier("AddTask"))
              .build();
        }
      }
    }
    return getAddTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdateTaskRequest,
      TaskResponse> getUpdateTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTask",
      requestType = UpdateTaskRequest.class,
      responseType = TaskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateTaskRequest,
      TaskResponse> getUpdateTaskMethod() {
    io.grpc.MethodDescriptor<UpdateTaskRequest, TaskResponse> getUpdateTaskMethod;
    if ((getUpdateTaskMethod = TaskServiceGrpc.getUpdateTaskMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getUpdateTaskMethod = TaskServiceGrpc.getUpdateTaskMethod) == null) {
          TaskServiceGrpc.getUpdateTaskMethod = getUpdateTaskMethod =
              io.grpc.MethodDescriptor.<UpdateTaskRequest, TaskResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TaskResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TaskServiceMethodDescriptorSupplier("UpdateTask"))
              .build();
        }
      }
    }
    return getUpdateTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DeleteTaskRequest,
      BooleanResponse> getDeleteTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTask",
      requestType = DeleteTaskRequest.class,
      responseType = BooleanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DeleteTaskRequest,
      BooleanResponse> getDeleteTaskMethod() {
    io.grpc.MethodDescriptor<DeleteTaskRequest, BooleanResponse> getDeleteTaskMethod;
    if ((getDeleteTaskMethod = TaskServiceGrpc.getDeleteTaskMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getDeleteTaskMethod = TaskServiceGrpc.getDeleteTaskMethod) == null) {
          TaskServiceGrpc.getDeleteTaskMethod = getDeleteTaskMethod =
              io.grpc.MethodDescriptor.<DeleteTaskRequest, BooleanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DeleteTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  BooleanResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TaskServiceMethodDescriptorSupplier("DeleteTask"))
              .build();
        }
      }
    }
    return getDeleteTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetAllTasksRequest,
      GetAllTasksResponse> getGetAllTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllTasks",
      requestType = GetAllTasksRequest.class,
      responseType = GetAllTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetAllTasksRequest,
      GetAllTasksResponse> getGetAllTasksMethod() {
    io.grpc.MethodDescriptor<GetAllTasksRequest, GetAllTasksResponse> getGetAllTasksMethod;
    if ((getGetAllTasksMethod = TaskServiceGrpc.getGetAllTasksMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getGetAllTasksMethod = TaskServiceGrpc.getGetAllTasksMethod) == null) {
          TaskServiceGrpc.getGetAllTasksMethod = getGetAllTasksMethod =
              io.grpc.MethodDescriptor.<GetAllTasksRequest, GetAllTasksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllTasks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetAllTasksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetAllTasksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TaskServiceMethodDescriptorSupplier("GetAllTasks"))
              .build();
        }
      }
    }
    return getGetAllTasksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TaskServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TaskServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TaskServiceStub>() {
        @Override
        public TaskServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TaskServiceStub(channel, callOptions);
        }
      };
    return TaskServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TaskServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TaskServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TaskServiceBlockingStub>() {
        @Override
        public TaskServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TaskServiceBlockingStub(channel, callOptions);
        }
      };
    return TaskServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TaskServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TaskServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TaskServiceFutureStub>() {
        @Override
        public TaskServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TaskServiceFutureStub(channel, callOptions);
        }
      };
    return TaskServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TaskServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTask(GetTaskRequest request,
                        io.grpc.stub.StreamObserver<TaskResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTaskMethod(), responseObserver);
    }

    /**
     */
    public void addTask(AddTaskRequest request,
                        io.grpc.stub.StreamObserver<TaskResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddTaskMethod(), responseObserver);
    }

    /**
     */
    public void updateTask(UpdateTaskRequest request,
                           io.grpc.stub.StreamObserver<TaskResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTaskMethod(), responseObserver);
    }

    /**
     */
    public void deleteTask(DeleteTaskRequest request,
                           io.grpc.stub.StreamObserver<BooleanResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTaskMethod(), responseObserver);
    }

    /**
     */
    public void getAllTasks(GetAllTasksRequest request,
                            io.grpc.stub.StreamObserver<GetAllTasksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllTasksMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetTaskRequest,
                TaskResponse>(
                  this, METHODID_GET_TASK)))
          .addMethod(
            getAddTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                AddTaskRequest,
                TaskResponse>(
                  this, METHODID_ADD_TASK)))
          .addMethod(
            getUpdateTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                UpdateTaskRequest,
                TaskResponse>(
                  this, METHODID_UPDATE_TASK)))
          .addMethod(
            getDeleteTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                DeleteTaskRequest,
                BooleanResponse>(
                  this, METHODID_DELETE_TASK)))
          .addMethod(
            getGetAllTasksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetAllTasksRequest,
                GetAllTasksResponse>(
                  this, METHODID_GET_ALL_TASKS)))
          .build();
    }
  }

  /**
   */
  public static final class TaskServiceStub extends io.grpc.stub.AbstractAsyncStub<TaskServiceStub> {
    private TaskServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TaskServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TaskServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTask(GetTaskRequest request,
                        io.grpc.stub.StreamObserver<TaskResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addTask(AddTaskRequest request,
                        io.grpc.stub.StreamObserver<TaskResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateTask(UpdateTaskRequest request,
                           io.grpc.stub.StreamObserver<TaskResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteTask(DeleteTaskRequest request,
                           io.grpc.stub.StreamObserver<BooleanResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllTasks(GetAllTasksRequest request,
                            io.grpc.stub.StreamObserver<GetAllTasksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllTasksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TaskServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TaskServiceBlockingStub> {
    private TaskServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TaskServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TaskServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public TaskResponse getTask(GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public TaskResponse addTask(AddTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public TaskResponse updateTask(UpdateTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public BooleanResponse deleteTask(DeleteTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public GetAllTasksResponse getAllTasks(GetAllTasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllTasksMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TaskServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TaskServiceFutureStub> {
    private TaskServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TaskServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TaskServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TaskResponse> getTask(
        GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TaskResponse> addTask(
        AddTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TaskResponse> updateTask(
        UpdateTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<BooleanResponse> deleteTask(
        DeleteTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetAllTasksResponse> getAllTasks(
        GetAllTasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllTasksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TASK = 0;
  private static final int METHODID_ADD_TASK = 1;
  private static final int METHODID_UPDATE_TASK = 2;
  private static final int METHODID_DELETE_TASK = 3;
  private static final int METHODID_GET_ALL_TASKS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TaskServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TaskServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TASK:
          serviceImpl.getTask((GetTaskRequest) request,
              (io.grpc.stub.StreamObserver<TaskResponse>) responseObserver);
          break;
        case METHODID_ADD_TASK:
          serviceImpl.addTask((AddTaskRequest) request,
              (io.grpc.stub.StreamObserver<TaskResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TASK:
          serviceImpl.updateTask((UpdateTaskRequest) request,
              (io.grpc.stub.StreamObserver<TaskResponse>) responseObserver);
          break;
        case METHODID_DELETE_TASK:
          serviceImpl.deleteTask((DeleteTaskRequest) request,
              (io.grpc.stub.StreamObserver<BooleanResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_TASKS:
          serviceImpl.getAllTasks((GetAllTasksRequest) request,
              (io.grpc.stub.StreamObserver<GetAllTasksResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TaskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TaskServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return TaskServiceV3.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TaskService");
    }
  }

  private static final class TaskServiceFileDescriptorSupplier
      extends TaskServiceBaseDescriptorSupplier {
    TaskServiceFileDescriptorSupplier() {}
  }

  private static final class TaskServiceMethodDescriptorSupplier
      extends TaskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TaskServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TaskServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TaskServiceFileDescriptorSupplier())
              .addMethod(getGetTaskMethod())
              .addMethod(getAddTaskMethod())
              .addMethod(getUpdateTaskMethod())
              .addMethod(getDeleteTaskMethod())
              .addMethod(getGetAllTasksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
