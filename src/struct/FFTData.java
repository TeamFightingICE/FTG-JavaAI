package struct;


import java.nio.ByteBuffer;

import protoc.MessageProto.GrpcFftData;

/**
 * The class representing Fast Fourier Transform data.<br>
 * For more details on the data structure, please see <a href="https://tinyurl.com/DareFightingICE/AI" target="blank">https://tinyurl.com/DareFightingICE/AI</a>.
 */
public class FFTData {
	
    /**
     * Real parts
     */
    private float[] real;

    /** 
     * Real parts as bytes
     */
    private byte[] realAsBytes;
    
    /**
     * Imaginary parts
     */
    private float[] imag;
    
    /**
     * Imaginary parts as bytes
     */
    private byte[] imagAsBytes;
    
    /**
     * @param fd
     * 		grpc data
     * 
     * @hidden
     */
    public FFTData(GrpcFftData fd) {
    	this.realAsBytes = fd.getRealDataAsBytes().toByteArray();
    	this.imagAsBytes = fd.getImaginaryDataAsBytes().toByteArray();
    	
    	this.real = new float[realAsBytes.length / 4];
    	this.imag = new float[realAsBytes.length / 4];
    	ByteBuffer realBuf = ByteBuffer.wrap(realAsBytes);
    	ByteBuffer imagBuf = ByteBuffer.wrap(imagAsBytes);
    	for (int i = 0; i < this.real.length; i++) {
    		this.real[i] = realBuf.getFloat();
    	}
    	for (int i = 0; i < this.imag.length; i++) {
    		this.imag[i] = imagBuf.getFloat();
    	}
    }

    /**
     * Gets real part.
     * @return real part.
     */
    public float[] getReal() {
        return real;
    }
    /**
     * Gets imaginary part.
     * @return imaginary part
     */
    public float[] getImag() {
        return imag;
    }

    /**
     * Byte sequence version of {@link #getReal()}.<br>
     * This method is recommended for Python-based AI
     * @return real part as byte sequence.
     */
    public byte[] getRealAsBytes() {
        return realAsBytes;
    }

    /**
     * Byte sequence version of {@link #getImag()}<br>
     * This method is recommended for Python-based AI
     * @return imaginary part as byte sequence.
     */
    public byte[] getImagAsBytes() {
        return imagAsBytes;
    }
}