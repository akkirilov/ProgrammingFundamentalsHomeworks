package p05_OnlineRadioDatabase;

public class InvalidSongLengthException extends InvalidSongException{

	public InvalidSongLengthException() {
		super.setMessage("Invalid song length.");
	}

}
