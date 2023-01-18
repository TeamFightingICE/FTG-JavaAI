package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import aiinterface.AIController;
import aiinterface.AIInterface;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import loader.ResourceLoader;
import protoc.ServiceGrpc;
import protoc.ServiceGrpc.ServiceBlockingStub;
import setting.LaunchSetting;

public class Game {

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
		this.channel = ManagedChannelBuilder
			.forAddress(LaunchSetting.grpcAddr, LaunchSetting.grpcPort)
			.usePlaintext()
			.build();
		this.stub = ServiceGrpc.newBlockingStub(channel);
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
