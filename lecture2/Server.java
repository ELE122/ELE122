package lecture2;

public class Server {
	private String ipAddress;
	private int port;
	private boolean running = false;
	
	public Server(String ipAddress, int port) {
		this.ipAddress = ipAddress;
		this.port = port;
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
