package lecture3;

public class Mail extends Message {

	private String subject;

	public Mail(String sender, String receiver, String body, String subject) {
		super(sender, receiver, body);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	// Here we override serialize() from Message since we want a
	// different behavior
	public String serialize() {
		String serializedSegment = getSender() + "," +
				getReceiver() + "," + subject + "," + getBody();
		return serializedSegment;
	}
}
