package lecture3;

public class MessageClient {

	public static void main(String[] args) {
		ChatMessage aChatMessage = new ChatMessage("andreas", "espen", "Hello");
		String chatMessageSerialized = aChatMessage.serialize();
		System.out.println(chatMessageSerialized);

		MailMessage aMailMessage = new MailMessage("andreas", "espen", "Hilsen", "hello");
		String mailMessageSerialized = aMailMessage.serialize();
		System.out.println(mailMessageSerialized);

		// Where does this metod come from? It is not in the MailMessage class
		String mailBody = aMailMessage.getBody();
		System.out.println(mailBody);

		// Polymorphism
		Message aMessageObject = aMailMessage;
		System.out.println(aMessageObject.serialize());

		Message[] arrayOfMessages = {aChatMessage, aMailMessage};

		for (int i = 0; i < 2; i++) {
			String serializedMessage = arrayOfMessages[i].serialize();
			System.out.println(serializedMessage);

			// What happens if we call getSubject()?
			//messageObject.getSubject();
		}
	}
}
