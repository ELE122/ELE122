package lecture5;

import java.io.*;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;


public class NetworkUtility {
	//Static method that 
	public static void writeInterfaceListToFile(String filename) {
		// Get a list of this host's network interfaces
		Enumeration<NetworkInterface> interfaceList = null;
		PrintWriter pw = null;
		
		try {
			//getNetworkInterfaces(); returns a list containing an instance of NetworkInterface for each host
			//Throws SocketException
			interfaceList = NetworkInterface.getNetworkInterfaces(); 
			
			//Opens a new PrintWriter with the specified file name, throws FileNotFoundException
			pw = new PrintWriter(filename);
			
			//Iterate through interfaceList and print interface info to file
			while (interfaceList.hasMoreElements()) {
				NetworkInterface networkInterface = (NetworkInterface) interfaceList.nextElement();
				pw.println(networkInterface.toString());
			}
		} catch (SocketException e) {
			System.err.println("SocketException: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (NoSuchElementException e) {
			System.err.println("NoSuchElementException: " + e.getMessage());
		}finally {
			//Must check null to avoid NullpointerException being thrown
			//Forgetting this provides a good example of how Good example of 
			//how a checked exception can lead into a RuntimeException
			if(pw != null) {
				pw.close();
			}	
		}
	}
}
