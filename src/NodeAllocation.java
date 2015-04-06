
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.lang.model.element.VariableElement;




public class NodeAllocation {

	private final int virtualNode = 10;

	public void NodeAllocate(List<String> servers) throws NoSuchAlgorithmException
	{
		ConsistentHash hash = new ConsistentHash();
		for(int i = 1; i < servers.size(); i++)
		{
			for(int j = 0; j < virtualNode + 1; j++)
			{
				String curServer = servers.get(i);
				byte[] d = hash.md5Hash(curServer+"-"+j);

				for(int h = 0; h < 4; h++)
				{//-20
					 Long k =
				                ((long)(d[3+h*4]&0xFF) << 24)
				                  | ((long)(d[2+h*4]&0xFF) << 16)
				                  | ((long)(d[1+h*4]&0xFF) << 8 )
				                  | ((long)(d[0+h*4]&0xFF));

					NodeBucket.nodeMap.put(k, curServer);
				}

			}



		}


	}
}
