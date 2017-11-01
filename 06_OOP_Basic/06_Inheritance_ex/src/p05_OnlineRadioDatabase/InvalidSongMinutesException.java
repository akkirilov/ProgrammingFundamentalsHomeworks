package p05_OnlineRadioDatabase;

public class InvalidSongMinutesException extends InvalidSongLengthException{

	public InvalidSongMinutesException() {
		super.setMessage("Song minutes should be between 0 and 14.");
	}

}
