package struct;

import protoc.MessageProto.GrpcRoundResult;

/**
 * A class that processes round results.
 */
public class RoundResult {
	
	/**
	 * Current round number
	 */
	private int currentRound;
	
	/**
	 * An array that stores the remaining HP of P1 and P2
	 */
	private int[] remainingHPs;
	
	/**
	 * The number of frames elapsed in the round
	 */
	private int elapsedFrame;
	
	/**
     * The class constructor.
     */
	public RoundResult() {
		this.currentRound = -1;
		this.remainingHPs = new int[2];
		this.elapsedFrame = -1;
	}
	
	/**
	 * @param rr
     * 		grpc data
	 * 
     * @hidden
     */
	public RoundResult(GrpcRoundResult rr) {
		this.currentRound = rr.getCurrentRound();
		this.remainingHPs = new int[2];
		this.remainingHPs[0] = rr.getRemainingHps(0);
		this.remainingHPs[1] = rr.getRemainingHps(1);
		this.elapsedFrame = rr.getElapsedFrame();
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
	 * Returns an array that stores the remaining HP of P1 and P2.
	 *
	 * @return An array that stores the remaining HP of P1 and P2
	 */
	public int[] getRemainingHPs() {
		return this.remainingHPs.clone();
	}

	/**
	 * Returns the number of elapsed frames.
	 *
	 * @return the number of elapsed frames
	 */
	public int getElapsedFrame() {
		return this.elapsedFrame;
	}
}
