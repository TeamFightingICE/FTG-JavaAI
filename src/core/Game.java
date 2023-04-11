package core;

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

	private static final String GZIP_COMPRESSION = "gzip";
	
	private ManagedChannel channel;
	private ServiceBlockingStub stub;
	private AIController[] ais =  new AIController[2];
	
	public Game() {
		
	}
	
	public void setOptions(String[] options) {
		for (int i = 0; i < options.length; i++) {
			switch (options[i]) {
				case "--a1":
	                LaunchSetting.aiNames[0] = options[++i];
					break;
	            case "--a2":
	                LaunchSetting.aiNames[1] = options[++i];
					break;
				case "--host":
					LaunchSetting.grpcAddr = options[++i];
					break;
				case "--port":
					LaunchSetting.grpcPort = Integer.parseInt(options[++i]);
					break;
			}
		}
	}
	
	public void initialize() {
		channel = NettyChannelBuilder
				.forAddress(LaunchSetting.grpcAddr, LaunchSetting.grpcPort)
				.usePlaintext()
				.flowControlWindow(16 * 1024)
				.build();
		stub = ServiceGrpc.newBlockingStub(channel).withCompression(GZIP_COMPRESSION);
	}
	
	public void start() {
		for (int i = 0; i < 2; i++) {
			if (LaunchSetting.aiNames[i] != null) {
				AIInterface ai = ResourceLoader.getInstance().loadAI(LaunchSetting.aiNames[i]);
				this.ais[i] = new AIController(stub, ai, i == 0);
				this.ais[i].start();
				Logger.getAnonymousLogger().log(Level.INFO, "AI controller for " + LaunchSetting.aiNames[i] + " is ready.");
			}
		}
	}
	
}
