package util;

import protoc.MessageProto.GrpcKey;
import struct.Key;

public class GrpcUtil {
  	
  	public static Key fromGrpcKey(GrpcKey grpcKey) {
  		Key key = new Key();
  		key.A = grpcKey.getA();
  		key.B = grpcKey.getB();
  		key.C = grpcKey.getC();
  		key.U = grpcKey.getU();
  		key.D = grpcKey.getD();
  		key.L = grpcKey.getL();
  		key.R = grpcKey.getR();
  		return key;
  	}
  	
    public static GrpcKey convertKey(Key key) {
    	if (key == null) key = new Key();
    	return GrpcKey.newBuilder()
    			.setA(key.A)
    			.setB(key.B)
    			.setC(key.C)
    			.setD(key.D)
    			.setL(key.L)
    			.setR(key.R)
    			.setU(key.U)
    			.build();
    }
	
}
