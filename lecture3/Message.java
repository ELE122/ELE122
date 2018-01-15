package lecture3;

public class Message {
	private String sender;
	private String receiver;
	private String body;

	public Message(String sender, String receiver, String body) {
		this.sender = sender;
		this.receiver = receiver;
		this.body = body;
	}

	public static void test() {
		System.out.println("superclass");
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String serialize() {
		String serializedSegment = sender + "," + receiver + "," + body;
		return serializedSegment;
	}
}
