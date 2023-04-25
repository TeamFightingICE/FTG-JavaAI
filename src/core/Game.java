package core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import aiinterface.AIController;
import aiinterface.AIInterface;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import loader.ResourceLoader;
import protoc.ServiceGrpc;
import protoc.ServiceGrpc.ServiceBlockingStub;
import setting.LaunchSetting;

public class Game {
	
	private ForkJoinPool pool;
	private ManagedChannel channel;
	private ServiceBlockingStub stub;
	private AIController[] ais =  new AIController[2];
	
	public Game() {
		
	}
	
	public void setOptions(String[] options) {
		for (int i = 0; i < options.length; i++) {
			switch (options[i]) {
				case "--a1":
	                LaunchSetting.AI_NAMES[0] = options[++i];
					break;
	            case "--a2":
	                LaunchSetting.AI_NAMES[1] = options[++i];
					break;
				case "--host":
					LaunchSetting.GRPC_ADDR = options[++i];
					break;
				case "--port":
					LaunchSetting.GRPC_PORT = Integer.parseInt(options[++i]);
					break;
				case "--pool-size":
					LaunchSetting.POOL_SIZE = Integer.parseInt(options[++i]);
					break;
				case "--flow-control-window":
					LaunchSetting.FLOW_CONTROL_WINDOW = Integer.parseInt(options[++i]);
					break;
			}
		}
	}
	
	public void initialize() {
		this.pool = new ForkJoinPool(LaunchSetting.POOL_SIZE);
		this.channel = NettyChannelBuilder
				.forAddress(LaunchSetting.GRPC_ADDR, LaunchSetting.GRPC_PORT)
				.usePlaintext()
				.executor(pool)
				.flowControlWindow(LaunchSetting.FLOW_CONTROL_WINDOW)
				.build();
		this.stub = ServiceGrpc.newBlockingStub(channel);
	}
	
	public void start() {
		List<ForkJoinTask<?>> tasks = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			if (LaunchSetting.AI_NAMES[i] != null) {
				AIInterface ai = ResourceLoader.getInstance().loadAI(LaunchSetting.AI_NAMES[i]);
				this.ais[i] = new AIController(stub, ai, i == 0);
			    tasks.add(this.pool.submit(this.ais[i]));
				Logger.getAnonymousLogger().log(Level.INFO, String.format("AI controller for P%d (%s) is ready.", i+1, LaunchSetting.AI_NAMES[i]));
			}
		}
		for (ForkJoinTask<?> task : tasks) {
			task.join();
		}
		this.pool.shutdownNow();
	}
	
}
