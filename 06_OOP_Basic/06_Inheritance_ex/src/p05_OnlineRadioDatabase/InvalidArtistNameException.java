package p05_OnlineRadioDatabase;

public class InvalidArtistNameException extends InvalidSongException{

	public InvalidArtistNameException() {
		super.setMessage("Artist name should be between 3 and 20 symbols.");
	}

}
