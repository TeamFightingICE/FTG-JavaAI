package aiinterface;

import java.util.Iterator;
import java.util.UUID;

import protoc.ServiceGrpc.ServiceBlockingStub;
import protoc.ServiceProto.InitializeRequest;
import protoc.ServiceProto.InitializeResponse;
import protoc.ServiceProto.ParticipateRequest;
import protoc.ServiceProto.PlayerGameState;
import protoc.ServiceProto.PlayerInput;
import struct.AudioData;
import struct.FrameData;
import struct.GameData;
import struct.Key;
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
	
	private void initializeRPC() {
		InitializeRequest request = InitializeRequest.newBuilder()
				.setPlayerNumber(this.playerNumber)
				.setPlayerName(this.ai.name())
				.setIsBlind(this.ai.isBlind())
				.build();
		InitializeResponse response = this.stub.initialize(request);
		this.playerUuid = UUID.fromString(response.getPlayerUuid());
	}
	
	private Iterator<PlayerGameState> participateRPC() {
		ParticipateRequest request = ParticipateRequest.newBuilder().setPlayerUuid(this.playerUuid.toString()).build();
		return this.stub.participate(request);
	}
	
	private void inputRPC(Key key) {
		PlayerInput input = PlayerInput.newBuilder()
				.setPlayerUuid(this.playerUuid.toString())
				.setInputKey(GrpcUtil.convertKey(key))
				.build();
		this.stub.input(input);
	}
	
	@Override
	public void run() {
		this.initializeRPC();
		Iterator<PlayerGameState> gameDataIterator = this.participateRPC();
		while (gameDataIterator.hasNext()) {
			PlayerGameState state = gameDataIterator.next();
			switch (state.getStateFlag()) {
			case INITIALIZE:
				this.ai.initialize(new GameData(state.getGameData()), playerNumber);
				break;
			case PROCESSING:
				this.ai.getInformation(new FrameData(state.getFrameData()), state.getIsControl());
				
				if (state.hasScreenData()) {
					this.ai.getScreenData(new ScreenData(state.getScreenData()));
				}
				
				if (state.hasAudioData()) {
					this.ai.getAudioData(new AudioData(state.getAudioData()));
				}
				
				this.ai.processing();
				this.inputRPC(this.ai.input());
				break;
			case ROUND_END:
				this.ai.roundEnd(new RoundResult(state.getRoundResult()));
				break;
			case GAME_END:
				this.ai.gameEnd();
				break;
			default:
				break;
			}
		}
	}
	
}
