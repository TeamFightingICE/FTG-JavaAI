package struct;

import java.util.Deque;
import java.util.LinkedList;

import protoc.MessageProto.GrpcAttackData;
import protoc.MessageProto.GrpcFrameData;

/**
 * The class dealing with the information in the game such as the current frame
 * number, number of rounds and character information.
 */
public class FrameData {

    /**
     * The character's data of both characters<br>
     * Index 0 is P1, index 1 is P2.
     */
    private CharacterData[] characterData;

    /**
     * The current frame of the round.
     */
    private int currentFrameNumber;

    /**
     * The current round number.
     */
    private int currentRound;

    /**
     * The projectile data of both characters.
     */
    private Deque<AttackData> projectileData;

    /**
     * If this value is true, no data are available or they are dummy data.
     */
    private boolean emptyFlag;

    /**
     * imported from {@link CharacterData's front}
     */
    private boolean[] front;

    /**
     * The class constructor.
     */
    public FrameData() {
        this.characterData = new CharacterData[]{null, null};
        this.currentFrameNumber = -1;
        this.currentRound = -1;
        this.projectileData = new LinkedList<AttackData>();
        this.emptyFlag = true;
        this.front = new boolean[2];
    }
    
    public FrameData(GrpcFrameData fd) {
        this();
        
        if (fd.getCharacterDataCount() == 2) {
        	this.characterData[0] = new CharacterData(fd.getCharacterData(0));
            this.characterData[1] = new CharacterData(fd.getCharacterData(1));
        }
        this.currentFrameNumber = fd.getCurrentFrameNumber();
        this.currentRound = fd.getCurrentRound();
        for (GrpcAttackData attack : fd.getProjectileDataList()) {
        	this.projectileData.add(new AttackData(attack));
        }
        this.emptyFlag = fd.getEmptyFlag();
        if (fd.getFrontCount() == 2) {
        	this.front[0] = fd.getFront(0);
            this.front[1] = fd.getFront(1);
        }
    }

    /**
     * Returns an instance of the CharacterData class of the player specified by
     * an argument.
     *
     * @param playerNumber the number of the player. {@code true} if the player is P1, or
     *                     {@code false} if P2.
     * @return an instance of the CharacterData class of the player
     */
    public CharacterData getCharacter(boolean playerNumber) {
    	return this.characterData[playerNumber ? 0 : 1];
    }

    /**
     * Returns the number of frames since the beginning of the round.
     *
     * @return the number of frames since the beginning of the round
     */
    public int getFramesNumber() {
        return this.currentFrameNumber;
    }

    /**
     * Returns the current round number.
     *
     * @return the current round number
     */
    public int getRound() {
        return this.currentRound;
    }

    /**
     * Returns the projectile data of both characters.
     *
     * @return the projectile data of both characters
     */
    public Deque<AttackData> getProjectiles() {
        return this.projectileData;
    }

    /**
     * Returns the projectile data of player 1.
     *
     * @return the projectile data of player 1
     */
    public Deque<AttackData> getProjectilesByP1() {
        LinkedList<AttackData> attackList = new LinkedList<AttackData>();
        for (AttackData attack : this.projectileData) {
            if (attack.isPlayerNumber()) {
                attackList.add(attack);
            }
        }
        return attackList;
    }

    /**
     * Returns the projectile data of player 2.
     *
     * @return the projectile data of player 2
     */
    public Deque<AttackData> getProjectilesByP2() {
        LinkedList<AttackData> attackList = new LinkedList<AttackData>();
        for (AttackData attack : this.projectileData) {
            if (!attack.isPlayerNumber()) {
                attackList.add(attack);
            }
        }
        return attackList;
    }

    /**
     * Returns true if this instance is empty, false if it contains meaningful
     * data.
     *
     * @return {@code true} if this instance is empty, or {@code false} if it
     * contains meaningful data
     */
    public boolean getEmptyFlag() {
        return this.emptyFlag;
    }

    /**
     * Returns the horizontal distance between P1 and P2.
     *
     * @return the horizontal distance between P1 and P2
     */
    public int getDistanceX() {
        return Math.abs((this.characterData[0].getCenterX() - this.characterData[1].getCenterX()));
    }

    /**
     * Returns the vertical distance between P1 and P2.
     *
     * @return the vertical distance between P1 and P2
     */
    public int getDistanceY() {
        return Math.abs((this.characterData[0].getCenterY() - this.characterData[1].getCenterY()));
    }

    public boolean isFront(boolean player) {
        return this.front[player ? 0 : 1];
    }
}