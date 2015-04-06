

import java.awt.List;
import java.io.Console;
import java.net.URLStreamHandler;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.lang.model.element.VariableElement;

import org.omg.CORBA.PUBLIC_MEMBER;


public class Client {
	public static void main(String[] args) {


		ArrayList<String> ips = new ArrayList<String>();
		String preIp = "192.168.1.";
		for(int i = 1; i < 20; i++)
		{
			ips.add(preIp+i);
		}

		NodeAllocation allocation = new NodeAllocation();
		try {
			allocation.NodeAllocate(ips);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ArrayList<String> urls = new ArrayList<String>();
		 urls.add("http://www.book.douban.com");
		 urls.add("http://www.movie.douban.com");
		 urls.add("http://www.music.douban.com");
		 urls.add("http://www.douban.com/location");
		 urls.add("http://www.douban.fm");
		 urls.add("http://www.9.douban.com/");
		 urls.add("http://www.alphatown.com");
		 KeyAllocation kAllocation = new KeyAllocation();
		 for (String u : urls) {
			long k;
			try {
				k = kAllocation.GetPosition(u);
				System.out.println("position:"+k);
				long nk = kAllocation.GetAllocatedToNode(k);
				System.out.println("toNode:" +nk);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}




	}

}
