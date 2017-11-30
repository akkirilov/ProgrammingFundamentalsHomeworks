package p02_WarningLevels;

public class Message {
	
	private Importance importance;
	private String message;

	public Message(Importance importance, String message) {
		this.message = message;
		this.importance = importance;
	}

	@Override
	public String toString() {
		return importance.name() + ": " + message;
	}

}
