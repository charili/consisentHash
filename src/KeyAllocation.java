import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;


public class KeyAllocation {

	public long GetPosition(String value) throws NoSuchAlgorithmException
	{
		ConsistentHash hash = new ConsistentHash();
		byte[] bKey = hash.md5Hash(value);
		long hv = ((long)(bKey[3]&0xFF) << 24) | ((long)(bKey[2]&0xFF) << 16) | ((long)(bKey[1]&0xFF) << 8 ) | (long)(bKey[0]&0xFF);
		return hv;

	}

	public long GetAllocatedToNode(long hashValue)
	{

		SortedMap<Long, String> sm = NodeBucket.nodeMap.tailMap(hashValue);
		return sm.isEmpty()? NodeBucket.nodeMap.firstKey():sm.firstKey();

	}


}
