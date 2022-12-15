package protoc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServiceGrpc {

  private ServiceGrpc() {}

  public static final String SERVICE_NAME = "service.Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<protoc.ServiceProto.SpectateRequest,
      protoc.ServiceProto.SpectatorGameData> getSpectateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Spectate",
      requestType = protoc.ServiceProto.SpectateRequest.class,
      responseType = protoc.ServiceProto.SpectatorGameData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<protoc.ServiceProto.SpectateRequest,
      protoc.ServiceProto.SpectatorGameData> getSpectateMethod() {
    io.grpc.MethodDescriptor<protoc.ServiceProto.SpectateRequest, protoc.ServiceProto.SpectatorGameData> getSpectateMethod;
    if ((getSpectateMethod = ServiceGrpc.getSpectateMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getSpectateMethod = ServiceGrpc.getSpectateMethod) == null) {
          ServiceGrpc.getSpectateMethod = getSpectateMethod =
              io.grpc.MethodDescriptor.<protoc.ServiceProto.SpectateRequest, protoc.ServiceProto.SpectatorGameData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Spectate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  protoc.ServiceProto.SpectateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  protoc.ServiceProto.SpectatorGameData.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("Spectate"))
              .build();
        }
      }
    }
    return getSpectateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<protoc.ServiceProto.InitializeRequest,
      protoc.ServiceProto.InitializeResponse> getInitializeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Initialize",
      requestType = protoc.ServiceProto.InitializeRequest.class,
      responseType = protoc.ServiceProto.InitializeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<protoc.ServiceProto.InitializeRequest,
      protoc.ServiceProto.InitializeResponse> getInitializeMethod() {
    io.grpc.MethodDescriptor<protoc.ServiceProto.InitializeRequest, protoc.ServiceProto.InitializeResponse> getInitializeMethod;
    if ((getInitializeMethod = ServiceGrpc.getInitializeMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getInitializeMethod = ServiceGrpc.getInitializeMethod) == null) {
          ServiceGrpc.getInitializeMethod = getInitializeMethod =
              io.grpc.MethodDescriptor.<protoc.ServiceProto.InitializeRequest, protoc.ServiceProto.InitializeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Initialize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  protoc.ServiceProto.InitializeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  protoc.ServiceProto.InitializeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("Initialize"))
              .build();
        }
      }
    }
    return getInitializeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<protoc.ServiceProto.ParticipateRequest,
      protoc.ServiceProto.PlayerGameData> getParticipateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Participate",
      requestType = protoc.ServiceProto.ParticipateRequest.class,
      responseType = protoc.ServiceProto.PlayerGameData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<protoc.ServiceProto.ParticipateRequest,
      protoc.ServiceProto.PlayerGameData> getParticipateMethod() {
    io.grpc.MethodDescriptor<protoc.ServiceProto.ParticipateRequest, protoc.ServiceProto.PlayerGameData> getParticipateMethod;
    if ((getParticipateMethod = ServiceGrpc.getParticipateMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getParticipateMethod = ServiceGrpc.getParticipateMethod) == null) {
          ServiceGrpc.getParticipateMethod = getParticipateMethod =
              io.grpc.MethodDescriptor.<protoc.ServiceProto.ParticipateRequest, protoc.ServiceProto.PlayerGameData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Participate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  protoc.ServiceProto.ParticipateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  protoc.ServiceProto.PlayerGameData.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("Participate"))
              .build();
        }
      }
    }
    return getParticipateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<protoc.ServiceProto.PlayerAction,
      com.google.protobuf.Empty> getInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Input",
      requestType = protoc.ServiceProto.PlayerAction.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<protoc.ServiceProto.PlayerAction,
      com.google.protobuf.Empty> getInputMethod() {
    io.grpc.MethodDescriptor<protoc.ServiceProto.PlayerAction, com.google.protobuf.Empty> getInputMethod;
    if ((getInputMethod = ServiceGrpc.getInputMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getInputMethod = ServiceGrpc.getInputMethod) == null) {
          ServiceGrpc.getInputMethod = getInputMethod =
              io.grpc.MethodDescriptor.<protoc.ServiceProto.PlayerAction, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Input"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  protoc.ServiceProto.PlayerAction.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("Input"))
              .build();
        }
      }
    }
    return getInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<protoc.ServiceProto.SimulateRequest,
      protoc.ServiceProto.SimulateResponse> getSimulateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Simulate",
      requestType = protoc.ServiceProto.SimulateRequest.class,
      responseType = protoc.ServiceProto.SimulateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<protoc.ServiceProto.SimulateRequest,
      protoc.ServiceProto.SimulateResponse> getSimulateMethod() {
    io.grpc.MethodDescriptor<protoc.ServiceProto.SimulateRequest, protoc.ServiceProto.SimulateResponse> getSimulateMethod;
    if ((getSimulateMethod = ServiceGrpc.getSimulateMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getSimulateMethod = ServiceGrpc.getSimulateMethod) == null) {
          ServiceGrpc.getSimulateMethod = getSimulateMethod =
              io.grpc.MethodDescriptor.<protoc.ServiceProto.SimulateRequest, protoc.ServiceProto.SimulateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Simulate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  protoc.ServiceProto.SimulateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  protoc.ServiceProto.SimulateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("Simulate"))
              .build();
        }
      }
    }
    return getSimulateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceStub>() {
        @java.lang.Override
        public ServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceStub(channel, callOptions);
        }
      };
    return ServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceBlockingStub>() {
        @java.lang.Override
        public ServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceBlockingStub(channel, callOptions);
        }
      };
    return ServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceFutureStub>() {
        @java.lang.Override
        public ServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceFutureStub(channel, callOptions);
        }
      };
    return ServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void spectate(protoc.ServiceProto.SpectateRequest request,
        io.grpc.stub.StreamObserver<protoc.ServiceProto.SpectatorGameData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSpectateMethod(), responseObserver);
    }

    /**
     */
    public void initialize(protoc.ServiceProto.InitializeRequest request,
        io.grpc.stub.StreamObserver<protoc.ServiceProto.InitializeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitializeMethod(), responseObserver);
    }

    /**
     */
    public void participate(protoc.ServiceProto.ParticipateRequest request,
        io.grpc.stub.StreamObserver<protoc.ServiceProto.PlayerGameData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getParticipateMethod(), responseObserver);
    }

    /**
     */
    public void input(protoc.ServiceProto.PlayerAction request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInputMethod(), responseObserver);
    }

    /**
     */
    public void simulate(protoc.ServiceProto.SimulateRequest request,
        io.grpc.stub.StreamObserver<protoc.ServiceProto.SimulateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSimulateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSpectateMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                protoc.ServiceProto.SpectateRequest,
                protoc.ServiceProto.SpectatorGameData>(
                  this, METHODID_SPECTATE)))
          .addMethod(
            getInitializeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                protoc.ServiceProto.InitializeRequest,
                protoc.ServiceProto.InitializeResponse>(
                  this, METHODID_INITIALIZE)))
          .addMethod(
            getParticipateMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                protoc.ServiceProto.ParticipateRequest,
                protoc.ServiceProto.PlayerGameData>(
                  this, METHODID_PARTICIPATE)))
          .addMethod(
            getInputMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                protoc.ServiceProto.PlayerAction,
                com.google.protobuf.Empty>(
                  this, METHODID_INPUT)))
          .addMethod(
            getSimulateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                protoc.ServiceProto.SimulateRequest,
                protoc.ServiceProto.SimulateResponse>(
                  this, METHODID_SIMULATE)))
          .build();
    }
  }

  /**
   */
  public static final class ServiceStub extends io.grpc.stub.AbstractAsyncStub<ServiceStub> {
    private ServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceStub(channel, callOptions);
    }

    /**
     */
    public void spectate(protoc.ServiceProto.SpectateRequest request,
        io.grpc.stub.StreamObserver<protoc.ServiceProto.SpectatorGameData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSpectateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void initialize(protoc.ServiceProto.InitializeRequest request,
        io.grpc.stub.StreamObserver<protoc.ServiceProto.InitializeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void participate(protoc.ServiceProto.ParticipateRequest request,
        io.grpc.stub.StreamObserver<protoc.ServiceProto.PlayerGameData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getParticipateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void input(protoc.ServiceProto.PlayerAction request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void simulate(protoc.ServiceProto.SimulateRequest request,
        io.grpc.stub.StreamObserver<protoc.ServiceProto.SimulateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSimulateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServiceBlockingStub> {
    private ServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<protoc.ServiceProto.SpectatorGameData> spectate(
        protoc.ServiceProto.SpectateRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSpectateMethod(), getCallOptions(), request);
    }

    /**
     */
    public protoc.ServiceProto.InitializeResponse initialize(protoc.ServiceProto.InitializeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializeMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<protoc.ServiceProto.PlayerGameData> participate(
        protoc.ServiceProto.ParticipateRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getParticipateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty input(protoc.ServiceProto.PlayerAction request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInputMethod(), getCallOptions(), request);
    }

    /**
     */
    public protoc.ServiceProto.SimulateResponse simulate(protoc.ServiceProto.SimulateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSimulateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ServiceFutureStub> {
    private ServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<protoc.ServiceProto.InitializeResponse> initialize(
        protoc.ServiceProto.InitializeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> input(
        protoc.ServiceProto.PlayerAction request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInputMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<protoc.ServiceProto.SimulateResponse> simulate(
        protoc.ServiceProto.SimulateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSimulateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SPECTATE = 0;
  private static final int METHODID_INITIALIZE = 1;
  private static final int METHODID_PARTICIPATE = 2;
  private static final int METHODID_INPUT = 3;
  private static final int METHODID_SIMULATE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SPECTATE:
          serviceImpl.spectate((protoc.ServiceProto.SpectateRequest) request,
              (io.grpc.stub.StreamObserver<protoc.ServiceProto.SpectatorGameData>) responseObserver);
          break;
        case METHODID_INITIALIZE:
          serviceImpl.initialize((protoc.ServiceProto.InitializeRequest) request,
              (io.grpc.stub.StreamObserver<protoc.ServiceProto.InitializeResponse>) responseObserver);
          break;
        case METHODID_PARTICIPATE:
          serviceImpl.participate((protoc.ServiceProto.ParticipateRequest) request,
              (io.grpc.stub.StreamObserver<protoc.ServiceProto.PlayerGameData>) responseObserver);
          break;
        case METHODID_INPUT:
          serviceImpl.input((protoc.ServiceProto.PlayerAction) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SIMULATE:
          serviceImpl.simulate((protoc.ServiceProto.SimulateRequest) request,
              (io.grpc.stub.StreamObserver<protoc.ServiceProto.SimulateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return protoc.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service");
    }
  }

  private static final class ServiceFileDescriptorSupplier
      extends ServiceBaseDescriptorSupplier {
    ServiceFileDescriptorSupplier() {}
  }

  private static final class ServiceMethodDescriptorSupplier
      extends ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceFileDescriptorSupplier())
              .addMethod(getSpectateMethod())
              .addMethod(getInitializeMethod())
              .addMethod(getParticipateMethod())
              .addMethod(getInputMethod())
              .addMethod(getSimulateMethod())
              .build();
        }
      }
    }
    return result;
  }
}