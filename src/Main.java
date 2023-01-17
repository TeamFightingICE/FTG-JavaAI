import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import aiinterface.AIController;
import aiinterface.AIInterface;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import protoc.ServiceGrpc;
import protoc.ServiceGrpc.ServiceBlockingStub;
import setting.LaunchSetting;

public class Main {
	
	private static void setOptions(String[] args) {
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
				case "--host":
					LaunchSetting.grpcAddr = args[++i];
					break;
				case "--port":
					LaunchSetting.grpcPort = Integer.parseInt(args[++i]);
					break;
			}
		}
	}
	
	public static AIInterface loadAI(String aiName) {
		File file = new File("./data/ai/" + aiName + ".jar");

		try {
			ClassLoader cl = URLClassLoader.newInstance(new URL[] { file.toURI().toURL() });
			Class<?> c = cl.loadClass(aiName);
			AIInterface ai = (AIInterface) c.getDeclaredConstructor(ServiceBlockingStub.class).newInstance();
			return ai;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		setOptions(args);
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(LaunchSetting.grpcAddr, LaunchSetting.grpcPort)
				.usePlaintext()
				.build();
		ServiceBlockingStub stub = ServiceGrpc.newBlockingStub(channel);
		
		AIInterface a1 = new KickAI();
		AIInterface a2 = new KickAI();
		
		AIController p1 = new AIController(stub, a1, true);
		AIController p2 = new AIController(stub, a2, false);
		p1.start();
		p2.start();
	}
	
}
