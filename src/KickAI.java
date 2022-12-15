import aiinterface.AIInterface;
import protoc.ServiceGrpc.ServiceBlockingStub;
import util.GrpcUtil;

public class KickAI extends AIInterface {

	public KickAI(ServiceBlockingStub stub) {
		super(stub);
		super.blind = true;
	}

	@Override
	protected void processing() {
		if (super.frameData.getEmptyFlag() || super.frameData.getCurrentFrameNumber() <= 0) {
			return;
		}
		
		if (super.commandCenter.getSkillKeyCount() > 0) {
			super.key = GrpcUtil.fromGrpcKey(this.commandCenter.getSkillKey(0));
			return;
		}
		
		super.calledCommand = "B";
	}
	
}
