package lecture6;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Espen Nilsen
 *This class defines a client that connects to a host and port given as arguments to its constructor.
 *The client expects to receive a random number from 0 to 100 from the server.
 *These are represented by a single byte an can thus be retrieved from the input stream by 
 *single call to the read() method.
 *The client is started by calling the startClient() method
 */

public class RandomClient {
	private String clientName = "Client";
	private int serverPort;
	private String serverHostName;
	private Socket socket = null;
	
	
	public RandomClient(String serverHostName, int serverPort) {
		this.serverPort = serverPort;
		this.serverHostName = serverHostName;
	}
	
	
	public void startClient() throws UnknownHostException, IOException {
		try {
			//Create a socket object that connects to the "remote" host and port
			socket =  new Socket(serverHostName, serverPort);
			
			System.out.println(clientName + ": TCP handshake done.");
			
			//read() and print the incoming random number
			System.out.println("Client: I got rand = " + socket.getInputStream().read() + " from the server" );
			System.out.println("Client: Thanks a lot! Closing now...");
			
		} finally {
			if (socket != null) {
					socket.close();
			}
		}	
	}
		

}
