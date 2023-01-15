package struct;

import java.nio.ByteBuffer;

import protoc.MessageProto.GrpcAudioData;
import setting.GameSetting;

/**
 * The class dealing with the audio information in game such as raw audio data, FFT and Mel-Spectrogram transformation.<br>
 * For more details on the data structure, please see <a href="https://tinyurl.com/DareFightingICE/AI" target="blank">https://tinyurl.com/DareFightingICE/AI</a>.
 */
public class AudioData {
    /**
     * Raw audio data.
     */
    private float[][] rawData = null;
    /**
     * Raw audio data as byte sequence.
     */
    private byte[] rawDataAsBytes = null;

    /**
     * Fourier-transformed audio data.
     */
    private FFTData[] fftData = null;
    /**
     * Mel-Spectrogram audio data.
     */
    private float[][][] spectrogramData = null;
    /**
     * Mel-Spectrogram audio data as byte sequence.
     */
    private byte[] spectrogramDataAsBytes = null;

    /**
     * Initialize data.
     */
    public AudioData() {
        this.rawData = new float[2][GameSetting.SOUND_BUFFER_SIZE];
        this.fftData = new FFTData[2];
        this.spectrogramData = new float[2][][];
    }
    
    public AudioData(GrpcAudioData ad) {
    	this();
    	
    	this.rawDataAsBytes = ad.getRawDataAsBytes().toByteArray();
    	this.fftData[0] = new FFTData(ad.getFftData(0));
    	this.fftData[1] = new FFTData(ad.getFftData(1));
    	this.spectrogramDataAsBytes = ad.getSpectrogramDataAsBytes().toByteArray();

    	ByteBuffer buf = ByteBuffer.wrap(rawDataAsBytes);
    	for (int i = 0; i < this.rawData.length; i++) {
    		for (int j = 0; j < this.rawData[i].length; j++) {
    			this.rawData[i][j] = buf.getFloat();
    		}
    	}
    }

    /**
     * Gets raw audio data.
     * @return raw audio data.
     */
    public float[][] getRawData() {
        return rawData;
    }

    /**
     * Byte sequence version of {@link #getRawData()}.<br>
     * This method is recommended for Python-based AI
     * @return raw audio data as byte sequence.
     */
    public byte[] getRawDataAsBytes() {
        return rawDataAsBytes;
    }

    /**
     * Gets Fast Fourier Transform data.
     * @return Fast Fourier Transform data.
     */
    public FFTData[] getFftData() {
        return fftData;
    }

    /**
     * Gets Mel-Spectrogram data.
     * @return Mel-Spectrogram data.
     */
    public float[][][] getSpectrogramData() {
        return spectrogramData;
    }

    /**
     * Byte sequence version of {@link #getSpectrogramData()}.<br>
     * This method is recommended for Python-based AI
     * @return Mel-Spectrogram data as byte sequence.
     */
    public byte[] getSpectrogramDataAsBytes() {
        return spectrogramDataAsBytes;
    }
}
