import aiinterface.AIInterface;
import aiinterface.CommandCenter;
import struct.AudioData;
import struct.FrameData;
import struct.Key;
import struct.RoundResult;
import struct.ScreenData;

public class KickAI implements AIInterface {

	private boolean blindFlag;
	private boolean playerNumber;
	private FrameData frameData;
	private ScreenData screenData;
	private AudioData audioData;
	private Key key;
	private CommandCenter cc;
	
	@Override
	public String name() {
		return this.getClass().getName();
	}
	
	@Override
	public boolean isBlind() {
		return this.blindFlag;
	}

	@Override
	public void initialize(boolean playerNumber) {
		this.playerNumber = playerNumber;
		
		this.key = new Key();
		this.cc = new CommandCenter();
		this.blindFlag = true;
	}
	
	@Override
	public void getInformation(FrameData frameData, boolean isControl) {
		this.frameData = frameData;
		this.cc.setFrameData(frameData, playerNumber);
	}
	
	@Override
	public void getScreenData(ScreenData screenData) {
		this.screenData = screenData;
	}

	@Override
	public void getAudioData(AudioData audioData) {
		this.audioData = audioData;
	}

	@Override
	public Key input() {
		return this.key;
	}

	@Override
	public void processing() {
		if (frameData.getEmptyFlag() || frameData.getFramesNumber() <= 0) {
			return;
		}
		
		System.out.println(playerNumber ? "P1" : "P2");
		System.out.println(screenData.getDisplayByteBufferAsBytes().length);
		System.out.println(audioData.getRawDataAsBytes().length);
		
		if (cc.getSkillFlag()) {
			key = cc.getSkillKey();
		} else {
			key.empty();
			cc.skillCancel();
			
			
			
			cc.commandCall("B");
		}
	}
	
	@Override
	public void roundEnd(RoundResult roundResult) {
		System.out.println(roundResult.getRemainingHPs()[0] + " " + roundResult.getRemainingHPs()[1] + " " + roundResult.getElapsedFrame());
	}
	
}
