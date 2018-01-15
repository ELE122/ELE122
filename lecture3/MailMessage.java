package lecture3;

public class MailMessage extends Message {

	private String subject;

	public MailMessage(String sender, String receiver, String body, String subject) {
		super(sender, receiver, body);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String serialize() {
		String serializedSegment = getSender() + "," +
				getReceiver() + "," + subject + "," + getBody();
		return serializedSegment;
	}
}
