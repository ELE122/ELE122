package lecture4;

import java.util.ArrayList;

public class MessageClient {

	public static void main(String[] args) {
		ChatMessage aChatMessage = new ChatMessage("andreas", "espen", "Hello");
		Mail aMail = new Mail("andreas", "espen", "Hilsen", "hello");
		PresenceUpdate userNowPresent = new PresenceUpdate("andreas", true);

		// Using array
//		Sendable[] queue = {aChatMessage, aMail, userNowPresent};
//		for (int i = 0; i < queue.length; i++) {
//		queue[i].send();
//	}
		
		// Using ArrayList
		ArrayList<Sendable> queue = new ArrayList<Sendable>();
		queue.add(aChatMessage);
		queue.add(aMail);
		queue.add(userNowPresent);

		for(Sendable objectToSend : queue) {
			objectToSend.send();
		}
	}
}
