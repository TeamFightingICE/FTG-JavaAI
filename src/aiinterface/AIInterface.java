package aiinterface;

import java.util.Iterator;
import java.util.UUID;

import protoc.MessageProto.GrpcAudioData;
import protoc.MessageProto.GrpcCommandCenter;
import protoc.MessageProto.GrpcFrameData;
import protoc.ServiceGrpc.ServiceBlockingStub;
import protoc.ServiceProto.InitializeRequest;
import protoc.ServiceProto.InitializeResponse;
import protoc.ServiceProto.ParticipateRequest;
import protoc.ServiceProto.PlayerAction;
import protoc.ServiceProto.PlayerGameData;
import struct.Key;
import util.GrpcUtil;

public abstract class AIInterface {
	
	private ServiceBlockingStub stub;
	private UUID playerUuid;
	private boolean playerNumber;
	protected boolean blind;
	
	protected GrpcCommandCenter commandCenter;
	protected GrpcFrameData frameData;
	protected GrpcAudioData audioData;
	
	protected Key key;
	protected String calledCommand;
	
	public AIInterface(ServiceBlockingStub stub) {
		this.stub = stub;
		
		this.key = new Key();
	}
	
	public UUID getPlayerUuid() {
		return this.playerUuid;
	}
	
	public boolean getPlayerNumber() {
		return this.playerNumber;
	}
	
	public boolean isBlind() {
		return this.blind;
	}
	
	private void initialize(boolean playerNumber) {
		InitializeRequest request = InitializeRequest.newBuilder()
				.setPlayerNumber(playerNumber)
				.setPlayerName(this.getClass().getName())
				.setIsBlind(this.isBlind())
				.build();
		InitializeResponse response = this.stub.initialize(request);
		this.playerUuid = UUID.fromString(response.getPlayerUuid());
		this.playerNumber = playerNumber;
	}
	
	private Iterator<PlayerGameData> participate() {
		ParticipateRequest request = ParticipateRequest.newBuilder().setPlayerUuid(this.playerUuid.toString()).build();
		return this.stub.participate(request);
	}
	
	protected abstract void processing();
	
	private void update(PlayerGameData response) {
		this.commandCenter = response.getCommandCenter();
		this.frameData = response.getFrameData();
		this.audioData = response.getAudioData();
	}
	
	private void call() {
		PlayerAction pAction;
		if (this.calledCommand != null) {
			pAction = PlayerAction.newBuilder()
					.setPlayerUuid(this.playerUuid.toString())
					.setCalledCommand(this.calledCommand)
					.build();
			this.calledCommand = null;
		} else {
			pAction = PlayerAction.newBuilder()
					.setPlayerUuid(this.playerUuid.toString())
					.setInputKey(GrpcUtil.convertKey(this.key))
					.build();
			this.key.empty();
		}
		this.stub.input(pAction);
	}
	
	public void start(boolean playerNumber) {
		this.initialize(playerNumber);
		Iterator<PlayerGameData> gameDataIterator = this.participate();
		while (gameDataIterator.hasNext()) {
			this.update(gameDataIterator.next());
			this.processing();
			this.call();
		}
	}
	
}
