package struct;

import protoc.MessageProto.GrpcGameData;

/**
 * The class dealing with invariable information in the game such as the screen
 * width of the stage and the chatacter's maximum HP.
 */
public class GameData {

	/**
	 * The values of both characters' HP limits.<br>
	 * Index 0 is P1, index 1 is P2.
	 */
	private int[] maxHPs;

	/**
	 * The values of both characters' energy limits.<br>
	 * Index 0 is P1, index 1 is P2.
	 */
	private int[] maxEnergies;

	/**
	 * The both characters' names.<br>
	 * Index 0 is P1, index 1 is P2.
	 */
	private String[] characterNames;

	/**
	 * The both AIs' names.<br>
	 * Index 0 is P1, index 1 is P2.
	 */
	private String[] aiNames;

	/**
	 * The class constructor.
	 * @hidden
	 */
	public GameData() {
		this.maxHPs = new int[2];
		this.maxEnergies = new int[2];
		this.characterNames = new String[2];
		this.aiNames = new String[2];
	}

	/**
	 * @param gameData
     * 		grpc data
	 * 
     * @hidden
     */
	public GameData(GrpcGameData gameData) {
		this();
		this.maxHPs[0] = gameData.getMaxHps(0);
		this.maxHPs[1] = gameData.getMaxHps(1);
		this.maxEnergies[0] = gameData.getMaxEnergies(0);
		this.maxEnergies[1] = gameData.getMaxEnergies(1);
		this.characterNames[0] = gameData.getCharacterNames(0);
		this.characterNames[1] = gameData.getCharacterNames(1);
		this.aiNames[0] = gameData.getAiNames(0);
		this.aiNames[1] = gameData.getAiNames(1);
	}

	/**
	 * Returns the maximum HP of the specified player.
	 *
	 * @param playerNumber
	 *            the player side's flag. {@code true} if the player is P1, or
	 *            {@code false} if P2.
	 * @return the maximum HP of the specified player
	 */
	public int getMaxHP(boolean playerNumber) {
		return playerNumber ? this.maxHPs[0] : this.maxHPs[1];
	}

	/**
	 * Returns the maximum energy of the specified player.
	 *
	 * @param playerNumber
	 *            the player side's flag. {@code true} if the player is P1, or
	 *            {@code false} if P2.
	 * @return the maximum energy of the specified player
	 */
	public int getMaxEnergy(boolean playerNumber) {
		return playerNumber ? this.maxEnergies[0] : this.maxEnergies[1];
	}

	/**
	 * Returns the character name of the specified player.
	 *
	 * @param playerNumber
	 *            the player side's flag. {@code true} if the player is P1, or
	 *            {@code false} if P2.
	 * @return the character name of the specified player
	 */
	public String getCharacterName(boolean playerNumber) {
		return playerNumber ? this.characterNames[0] : this.characterNames[1];
	}

	/**
	 * Returns the AI name of the specified player.
	 *
	 * @param playerNumber
	 *            the player side's flag. {@code true} if the player is P1, or
	 *            {@code false} if P2.
	 * @return the AI name of the specified player
	 */
	public String getAiName(boolean playerNumber) {
		return playerNumber ? this.aiNames[0] : this.aiNames[1];
	}
}
