package p05_OnlineRadioDatabase;

public class InvalidSongNameException extends InvalidSongException{

	public InvalidSongNameException() {
		super.setMessage("Song name should be between 3 and 30 symbols.");
	}

}
