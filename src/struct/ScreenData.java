package struct;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

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
		byte[] compressedData = sd.getDisplayBytes().toByteArray();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
            GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = gzipInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            gzipInputStream.close();
            byteArrayOutputStream.close();

            this.displayBytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.displayBytes = new byte[1];
        }
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
