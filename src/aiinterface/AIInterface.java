package aiinterface;

import struct.AudioData;
import struct.FrameData;
import struct.GameData;
import struct.Key;
import struct.RoundResult;
import struct.ScreenData;

public interface AIInterface {
	
	public String name();
	public boolean isBlind();
	public void initialize(GameData gameData, boolean playerNumber);
	public void getInformation(FrameData frameData, boolean isControl);
	public void getScreenData(ScreenData screenData);
	public void getAudioData(AudioData audioData);
	public void processing();
	public Key input();
	public void roundEnd(RoundResult roundResult);
	
}
