package struct;

import java.nio.ByteBuffer;

import protoc.MessageProto.GrpcScreenData;

/**
 * The class dealing with the screen information such as the game screen's image
 * and the background color.
 */
public class ScreenData {

	private ByteBuffer displayByteBuffer;
	
	public ScreenData(GrpcScreenData sd) {
		this.displayByteBuffer = ByteBuffer.wrap(sd.getDisplayBytes().toByteArray());
	}

	/**
	 * Obtains RGB data of the screen in the form of ByteBuffer.<br>
	 * Warning: If the window is disabled, will just return a black buffer.
	 *
	 * @return the RGB data of the screen in the form of ByteBuffer
	 */
	public ByteBuffer getDisplayByteBuffer() {
		return this.displayByteBuffer;
	}

	/**
	 * Obtains RGB data of the screen in the form of byte[].<br>
	 * Warning: If the window is disabled, will just return a black buffer.
	 *
	 * @return the RGB data of the screen in the form of byte[]
	 */
	public byte[] getDisplayByteBufferAsBytes() {
		byte[] buffer = new byte[this.displayByteBuffer.remaining()];
		this.displayByteBuffer.get(buffer);

		return buffer;
	}

}
