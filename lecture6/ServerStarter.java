package lecture6;

import java.io.IOException;

public class ServerStarter {

	public static void main(String[] args) throws IOException {	
			new RandomServer(4440).startServer();
	}

}
