package setting;

import java.util.concurrent.ForkJoinPool;

import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;

public class LaunchSetting {

	public static String[] AI_NAMES = { null, null };
	public static String GRPC_ADDR = "127.0.0.1";
	public static int GRPC_PORT = 50051;
	public static int POOL_SIZE = ForkJoinPool.getCommonPoolParallelism();
	public static int FLOW_CONTROL_WINDOW = NettyChannelBuilder.DEFAULT_FLOW_CONTROL_WINDOW;
	
}
