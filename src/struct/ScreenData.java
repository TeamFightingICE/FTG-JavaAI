package struct;

import protoc.MessageProto.GrpcScreenData;

/**
 * The class dealing with the screen information such as the game screen's image
 * and the background color.
 */
public class ScreenData {

	private byte[] displayBytes;
	
	public ScreenData(GrpcScreenData sd) {
		this.displayBytes = sd.getDisplayBytes().toByteArray();
	}

	/**
	 * Obtains RGB data of the screen in the form of ByteBuffer.<br>
	 * Warning: If the window is disabled, will just return a black buffer.
	 *
	 * @return the RGB data of the screen in the form of ByteBuffer
	 */
	public byte[] getDisplayBytes() {
		return this.displayBytes;
	}

}
