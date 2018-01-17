package lecture4;

public class PresenceUpdate implements Sendable {
	
	String user;
	boolean present;
	
	public PresenceUpdate(String user, boolean present) {
		this.user = user;
		this.present = present;
	}

	public String serialize() {
		return user + "," + present;
	}

	public void send() {
		System.out.println(serialize());
	}
}
