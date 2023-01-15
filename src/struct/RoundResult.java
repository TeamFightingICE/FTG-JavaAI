package struct;

import protoc.MessageProto.GrpcRoundResult;

/**
 * ラウンドの結果を処理するクラス．
 */
public class RoundResult {

	/**
	 * 現在のラウンド数．
	 */
	private int currentRound;

	/**
	 * P1とP2の残りHPを格納する配列．
	 */
	private int[] remainingHPs;

	/**
	 * ラウンドの経過フレーム数．
	 */
	private int elapsedFrame;

	/**
	 * クラスコンストラクタ．
	 */
	public RoundResult() {
		this.currentRound = -1;
		this.remainingHPs = new int[2];
		this.elapsedFrame = -1;
	}

	/**
	 * 指定された値でRoundResultを更新するクラスコンストラクタ．
	 *
	 * @param round
	 *            ラウンド数
	 * @param hp
	 *            P1,P2の残りHP
	 * @param frame
	 *            経過フレーム数
	 */
	public RoundResult(GrpcRoundResult rr) {
		this.currentRound = rr.getCurrentRound();
		this.remainingHPs = new int[2];
		this.remainingHPs[0] = rr.getRemainingHps(0);
		this.remainingHPs[1] = rr.getRemainingHps(1);
		this.elapsedFrame = rr.getElapsedFrame();
	}

	/**
	 * 現在のラウンド数を返す．
	 *
	 * @return 現在のラウンド数
	 */
	public int getRound() {
		return this.currentRound;
	}

	/**
	 * P1,P2の残りHPを格納した配列を返す．
	 *
	 * @return P1,P2の残りHPを格納した配列
	 */
	public int[] getRemainingHPs() {
		return this.remainingHPs.clone();
	}

	/**
	 * 経過フレーム数を返す．
	 *
	 * @return 経過フレーム数
	 */
	public int getElapsedFrame() {
		return this.elapsedFrame;
	}
}
