package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileHasher {

	public String sha256Hash(String file) {
		FileInputStream fis = null;

		try {
			//Create the objects, and open the file
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			fis = new FileInputStream(file);

			//New byte array to store binary hash
			byte[] dataBytes = new byte[1024];

			//as long as we can read from the file, toss it into the message digest
			int nread = 0;
			while ((nread = fis.read(dataBytes)) != -1)
				md.update(dataBytes, 0, nread);
			byte[] mdbytes = md.digest();

			//Read the bytes out, converting them into hex format.
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < mdbytes.length; i++)
				hexString.append(Integer.toHexString(0xFF & mdbytes[i]));

			//Return the resulting hex String
			return hexString.toString();
		} catch (IOException excep) {
			return "invalid file!";
		} catch (NoSuchAlgorithmException ex) {
			return "invalid algo exception!";
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}