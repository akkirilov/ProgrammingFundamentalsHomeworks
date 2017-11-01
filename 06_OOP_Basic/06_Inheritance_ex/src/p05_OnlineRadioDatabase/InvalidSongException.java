package p05_OnlineRadioDatabase;

public class InvalidSongException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	protected void setMessage(String message) {
		this.message = message;
	}
	
}
