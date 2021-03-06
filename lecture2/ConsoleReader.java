package lecture2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReader {

	public static void main(String[] args) throws IOException {

		// Setup reading from console
		InputStreamReader consoleInputStreamReader = new InputStreamReader(System.in);
		BufferedReader consoleInputBufferedReader = new BufferedReader(consoleInputStreamReader);
		
		// Instruct the user to input IP address
		System.out.println("Input IP address: ");
		
		// Read ip address from console
		String ipAddress = consoleInputBufferedReader.readLine();
		
		// Instruct the user to input port
		System.out.println("Input port: ");
		
		// Read another line from console - port
		String portAsString = consoleInputBufferedReader.readLine();
		
		// Parse string into int
		int port = Integer.parseInt(portAsString);

		// Pretty-print this to console
		System.out.println("Server ip: " + ipAddress + ":" + port);

		// Create a server object
		Server httpServer = new Server(ipAddress, port);
		httpServer.start();
		httpServer.printServerProperties();

		// Illustrate class member
		Server sshServer = new Server("0.0.0.0", 22);
		Server ftpServer = new Server("0.0.0.0", 21);
		Server smtpServer = new Server("0.0.0.0", 25);

		System.out.println(sshServer.getCounter());

		// Print the static member getNumberOfServers
		System.out.println(sshServer.getNumberOfServers());

		// We can call static methods using an object reference
		// However, it is not considered appropriate and gives a warning
		System.out.println(sshServer.getNumberOfServers());
	}

}
