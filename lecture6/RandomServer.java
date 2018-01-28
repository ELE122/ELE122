package lecture6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Espen Nilsen
 *Upon receiving an incoming connection, this server generates an integer random number from 0 to 100
 *and sends it to the client. The random number is represented by a single byte.
 *The server is started by calling startServer()
 */

public class RandomServer {
	private int serverPort;
	private ServerSocket serverSocket = null;
	private Socket currentClientSocket = null;
	
	public RandomServer(int port) {
		this.serverPort = port;
	}
	
	public void startServer() throws IOException  {
		
		try {
			//Create a server socket object and bind it to 'serverPort'
			serverSocket = new ServerSocket(serverPort);
		
			System.out.println("Server: bound to port " + serverPort + " ready to receive clients");
		
		while (true) {
			//Accept incoming client/data on the server socket
			currentClientSocket = serverSocket.accept();
			
			System.out.println("Server: New client arrived");
			
			//Fetch a random number
			int randomNumber = getRandomNumer(); 
			
			//Get an output stream and use it to write a byte
			currentClientSocket.getOutputStream().write(randomNumber);
			
			System.out.println("Server: Random number is " + randomNumber);
			
			//All sending is done close socket for this client 
			currentClientSocket.close();
			
			System.out.println("We closed the client socket" + currentClientSocket ); 
			
		}
		} finally {//Only reachable if an exception occurs. Make sure everything closes.
			if (currentClientSocket != null) {
				currentClientSocket.close();
			}
			if (serverSocket != null) {
				serverSocket.close();
			}
		}
		
	}
	
	private int getRandomNumer() {
		return (int) (Math.random()*101);
	}
	
	
}
