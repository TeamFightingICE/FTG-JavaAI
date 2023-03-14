package aiinterface;

import struct.AudioData;
import struct.FrameData;
import struct.GameData;
import struct.Key;
import struct.RoundResult;
import struct.ScreenData;

/**
 * The interface that defines the methods to implement in AI.
 */
public interface AIInterface {
	
	/**
	 * Receives a name from AI.
	 *
	 * @return the name of AI
	 */
	public String name();
	
	/**
	 * Receives whether or not the AI is blind.
	 *
	 * @return {@code true} if the AI is blind, otherwise {@code false} 
	 */
	public boolean isBlind();
	
	/**
	 * This method initializes AI, and it will be executed only once in the
	 * beginning of each game. <br>
	 * Its execution will load the data that cannot be changed and load the flag
	 * of the player's side ("Boolean player", <em>true</em> for P1 or
	 * <em>false</em> for P2). <br>
	 * If there is anything that needs to be initialized, you had better do it
	 * in this method. <br>
	 * It will return 0 when such initialization finishes correctly, otherwise
	 * the error code.
	 *
	 * @param gameData
	 *            the data that will not be changed during a game
	 * @param playerNumber
	 *            the character's side flag.<br>
	 *            {@code true} if the character is P1, or {@code false} if P2.
	 *
	 * @see GameData
	 */
	public void initialize(GameData gameData, boolean playerNumber);
	
	/**
	 * Gets information from the game status in each frame. <br>
	 * Such information is stored in the parameter frameData. <br>
	 * If {@code frameData.getRemainingTime()} returns a negative value, the
	 * current round has not started yet. <br>
	 * When you use frameData received from getInformation(), <br>
	 * you must always check if the condition
	 * {@code !frameData.getEmptyFlag() && frameData.getRemainingTime() > 0}
	 * holds; otherwise, NullPointerException will occur. <br>
	 * You must also check the same condition when you use the CommandCenter
	 * class.
	 *
	 * @param frameData
	 *            the data that will be changed each frame
	 * @param isControl
	 *            whether the character can act. this parameter is not delayed
	 *            unlike {@link struct.CharacterData#isControl()}
	 * @param nonDelayFrameData
	 *            the data that will be changed each frame with no delay (only available if --non-delay flag is set, otherwise {@code null})
	 * @see FrameData
	 */
	public void getInformation(FrameData frameData, boolean isControl, FrameData nonDelayFrameData);
	
	/**
	 * Gets the screen information in each frame.
	 *
	 * @param screenData
	 *            the screen information such as the pixel data, it will be empty in blind mode.
	 */
	public void getScreenData(ScreenData screenData);
	
	/**
	 * Gets the audio information in each frame.<br>
	 * For more details on the data structure, please see
	 * <a href="https://tinyurl.com/DareFightingICE/AI" target="blank">https://tinyurl.com/DareFightingICE/AI</a>.
	 * @param audioData
	 * 			the audio information.
	 *
	 */
	public void getAudioData(AudioData audioData);
	
	/**
	 * Processes the data from AI. <br>
	 * It is executed in each frame.
	 */
	public void processing();
	
	/**
	 * Receives a key input from AI.<br>
	 * It is executed in each frame and returns a value in the Key type.
	 *
	 * @return the value in the Key type
	 * @see Key
	 */
	public Key input();
	
	/**
	 * Informs the result of each round.<br>
	 * It is called when each round ends.<br>
	 *
	 * @param roundResult
	 *            the result of previous round
	 * @see RoundResult
	 */
	public void roundEnd(RoundResult roundResult);
	
	/**
	 * It is called when the game ends.<br>
	 */
	public void gameEnd();
	
}
