package lecture3;

public class MessageClient {

	public static void main(String[] args) {
		ChatMessage aChatMessage = new ChatMessage("andreas", "espen", "Hello");
		String chatMessageSerialized = aChatMessage.serialize();
		System.out.println(chatMessageSerialized);

		Mail aMail = new Mail("andreas", "espen", "Hilsen", "hello");
		String mailSerialized = aMail.serialize();
		System.out.println(mailSerialized);

		// Where does this metod come from? It is not in the Mail class
		String mailBody = aMail.getBody();
		System.out.println(mailBody);

		// Why is this allowed? (hint: is-a)
		Message aMessageObject = aMail;

		// Polymorphism
		// Which implementation of serialize() is called?
		System.out.println(aMessageObject.serialize());

		// A use-case for polymorphism
		Message[] arrayOfMessages = {aChatMessage, aMail};

		for (int i = 0; i < 2; i++) {
			String serializedMessage = arrayOfMessages[i].serialize();
			System.out.println(serializedMessage);

			// What happens if we call getSubject()?
			//messageObject.getSubject();
		}
	}
}
