package Number;

public class Number {
	public static String byte2Hex(byte[] input) {
		String hex = null;
		StringBuilder stringBuilder = new StringBuilder();
		String temp;
		for (byte B : input) {
			temp = Integer.toHexString(B & 0xff);
			if( temp.length() == 1 )
				stringBuilder.append("0");
			stringBuilder.append(temp);
		}
		hex = stringBuilder.toString();
		return hex;
	}
}
