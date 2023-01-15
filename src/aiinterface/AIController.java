package aiinterface;

import java.util.Iterator;
import java.util.UUID;

import protoc.ServiceGrpc.ServiceBlockingStub;
import protoc.ServiceProto.InitializeRequest;
import protoc.ServiceProto.InitializeResponse;
import protoc.ServiceProto.ParticipateRequest;
import protoc.ServiceProto.PlayerAction;
import protoc.ServiceProto.PlayerGameData;
import struct.AudioData;
import struct.FrameData;
import struct.GameData;
import struct.RoundResult;
import struct.ScreenData;
import util.GrpcUtil;

public class AIController extends Thread {

	private ServiceBlockingStub stub;
	private AIInterface ai;
	private UUID playerUuid;
	private boolean playerNumber;
	
	public AIController(ServiceBlockingStub stub, AIInterface ai, boolean playerNumber) {
		this.stub = stub;
		this.ai = ai;
		this.playerNumber = playerNumber;
	}
	
	private void initialize(boolean playerNumber) {
		InitializeRequest request = InitializeRequest.newBuilder()
				.setPlayerNumber(playerNumber)
				.setPlayerName(this.ai.name())
				.setIsBlind(this.ai.isBlind())
				.build();
		InitializeResponse response = this.stub.initialize(request);
		this.playerUuid = UUID.fromString(response.getPlayerUuid());
		this.playerNumber = playerNumber;
	}
	
	private Iterator<PlayerGameData> participate() {
		ParticipateRequest request = ParticipateRequest.newBuilder().setPlayerUuid(this.playerUuid.toString()).build();
		return this.stub.participate(request);
	}
	
	private void input() {
		PlayerAction.Builder pAction = PlayerAction.newBuilder()
				.setPlayerUuid(this.playerUuid.toString());
		pAction.setInputKey(GrpcUtil.convertKey(this.ai.input()));
		this.stub.input(pAction.build());
	}
	
	@Override
	public void run() {
		this.initialize(playerNumber);
		Iterator<PlayerGameData> gameDataIterator = this.participate();
		while (gameDataIterator.hasNext()) {
			PlayerGameData state = gameDataIterator.next();
			switch (state.getFlag()) {
			case INITIALIZE:
				this.ai.initialize(new GameData(state.getGameData()), playerNumber);
				break;
			case PROCESSING:
				this.ai.getInformation(new FrameData(state.getFrameData()), state.getIsControl());
				this.ai.getScreenData(new ScreenData(state.getScreenData()));
				this.ai.getAudioData(new AudioData(state.getAudioData()));
				this.ai.processing();
				this.input();
				break;
			case ROUND_END:
				this.ai.roundEnd(new RoundResult(state.getRoundResult()));
				break;
			default:
				break;
			}
		}
	}
	
}
