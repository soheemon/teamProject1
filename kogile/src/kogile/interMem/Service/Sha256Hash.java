package kogile.interMem.Service;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Hash {
	 
	    public static String sha256(String msg) throws NoSuchAlgorithmException {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(msg.getBytes());
	        
	        return bytesToHex1(md.digest());
	    }
	 
	    private static String bytesToHex1(byte[] bytes) {
	        StringBuilder builder = new StringBuilder();
	        for (byte b: bytes) {
	          builder.append(String.format("%02x", b));
	        }
	        return builder.toString();
	    }
}
