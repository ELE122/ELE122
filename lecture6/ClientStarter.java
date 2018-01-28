package lecture6;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientStarter {
	
	public static void main(String[] args) throws UnknownHostException, IOException {	
			new RandomClient("localhost",4440).startClient();		
	}

}
