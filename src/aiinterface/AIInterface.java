package aiinterface;

import java.util.Iterator;
import java.util.UUID;

import protoc.MessageProto.GrpcCommandCenter;
import protoc.ServiceGrpc.ServiceBlockingStub;
import protoc.ServiceProto.InitializeRequest;
import protoc.ServiceProto.InitializeResponse;
import protoc.ServiceProto.ParticipateRequest;
import protoc.ServiceProto.PlayerAction;
import protoc.ServiceProto.PlayerGameData;
import struct.Key;

public abstract class AIInterface {
	
	private ServiceBlockingStub stub;
	private UUID playerUuid;
	private boolean playerNumber;
	protected boolean blind;
	
	protected Key key;
	
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
	
	private Key input() {
		return this.key;
	}
	
	public void start(boolean playerNumber) {
		this.initialize(playerNumber);
		Iterator<PlayerGameData> gameDataIterator = this.participate();
		while (gameDataIterator.hasNext()) {
			PlayerGameData pGameData = gameDataIterator.next();
			this.processing();
			
			GrpcCommandCenter cc = pGameData.getCommandCenter();
			PlayerAction pAction;
			if (cc.getSkillKeyCount() > 0) {
				pAction = PlayerAction.newBuilder()
						.setPlayerUuid(this.playerUuid.toString())
						.setInputKey(cc.getSkillKey(0))
						.build();
			} else {
				pAction = PlayerAction.newBuilder()
						.setPlayerUuid(this.playerUuid.toString())
						.setCalledCommand("B")
						.build();
			}
			
			this.input();
			this.stub.input(pAction);
		}
	}
	
}
