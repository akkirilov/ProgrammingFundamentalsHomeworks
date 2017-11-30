package p02_WarningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
	
	Importance baseImportance;
	private List<Message> messages;
	
	public Logger(Importance baseImportance) {
		this.baseImportance = baseImportance;
		this.messages = new ArrayList<>();
	}
	
	public Iterable<Message> getMessages() {
		return this.messages;
	}
	
	public void addMessage(String importance, String message) {
		Importance imp = Importance.valueOf(importance.toUpperCase());
		if (baseImportance.compareTo(imp) <= 0) {
			this.messages.add(new Message(imp, message));
		}
	}

}
