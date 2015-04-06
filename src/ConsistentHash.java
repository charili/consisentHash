import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ConsistentHash {

	public byte[] md5Hash(String value) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("md5");
		md.update(value.getBytes());
		byte[] digest = md.digest();
		return digest;
	}

}
