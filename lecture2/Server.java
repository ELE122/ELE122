package lecture2;

public class Server {
	private String ipAddress;
	private int port;
	private boolean running = false;
	private int counter = 0;

	// Static field, belongs to the class, not objects of this class
	static private int numberOfServers = 0;

	public Server(String ipAddress, int port) {
		this.ipAddress = ipAddress;
		this.port = port;
		numberOfServers++;
		counter++;
	}

	// Static method, belongs to the class, not instances of the class
	public int getNumberOfServers() {
		return numberOfServers;
	}

	public int getCounter() {
		return counter;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void start() {
		running = true;
	}
	
	public void printServerProperties() {
		System.out.println("Server ip: " + ipAddress +
				":" + port + ", running: " + running);
	}
} 
