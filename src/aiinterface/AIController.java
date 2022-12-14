package aiinterface;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AIController extends Thread {

	private AIInterface ai;
	private boolean playerNumber;
	
	public AIController(AIInterface ai, boolean playerNumber) {
		this.ai = ai;
		this.playerNumber = playerNumber;
	}
	
	@Override
	public void run() {
		try {
			this.ai.start(this.playerNumber);
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Fail to connect gRPC server");
		}
	}
	
}
