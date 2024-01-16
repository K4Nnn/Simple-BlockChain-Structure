package Hashlib;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import Number.Number;

public class Hashlib {
	public static String sha256(String str) {
		MessageDigest messageDigest;
		String encodeStr = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
			encodeStr = Number.byte2Hex(messageDigest.digest());
		}catch(NoSuchAlgorithmException e) {//MessageDigest类的类方法getInstance声明了此异常
			System.out.println("SHA-256: "+e);
		}
		return encodeStr;
	}
}
