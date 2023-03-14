package struct;

import protoc.MessageProto.GrpcScreenData;

/**
 * The class dealing with the screen information such as the game screen's image
 * and the background color.
 */
public class ScreenData {

	/**
	 * RGB data of the screen in the form of bytes
	 */
	private byte[] displayBytes;
	
	/**
	 * @param sd
     * 		grpc data
	 * 
     * @hidden
     */
	public ScreenData(GrpcScreenData sd) {
		this.displayBytes = sd.getDisplayBytes().toByteArray();
	}

	/**
	 * Obtains RGB data of the screen in the form of bytes.
	 *
	 * @return the RGB data of the screen in the form of bytes
	 */
	public byte[] getDisplayBytes() {
		return this.displayBytes;
	}

}
