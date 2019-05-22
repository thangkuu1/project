package project.thangnd.utils;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
public class ConvertPassword {
	
	public String convertPassword(String password){
		String pass_new = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b: digest){
				sb.append(String.format("%02x", b & 0xff));
			}
			pass_new = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
		}
		return pass_new;
	}

}
