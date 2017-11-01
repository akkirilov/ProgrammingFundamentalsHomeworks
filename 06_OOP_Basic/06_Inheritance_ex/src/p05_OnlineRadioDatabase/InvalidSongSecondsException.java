package p05_OnlineRadioDatabase;

public class InvalidSongSecondsException extends InvalidSongLengthException{

	public InvalidSongSecondsException() {
		super.setMessage("Song seconds should be between 0 and 59.");
	}

}
