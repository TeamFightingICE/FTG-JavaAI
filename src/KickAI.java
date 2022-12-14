import aiinterface.AIInterface;
import protoc.ServiceGrpc.ServiceBlockingStub;

public class KickAI extends AIInterface {

	public KickAI(ServiceBlockingStub stub) {
		super(stub);
		super.blind = true;
	}

	@Override
	protected void processing() {
		// TODO Auto-generated method stub
		super.key.empty();
	}
	
}
