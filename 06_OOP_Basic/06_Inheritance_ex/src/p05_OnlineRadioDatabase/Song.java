package p05_OnlineRadioDatabase;

public class Song {
	
	private String artist;
	private String name;
	private int length;
	
	public Song(String artist, String name, String length)  throws InvalidSongException {
		super();
		setArtist(artist);
		setName(name);
		setLength(length);
	}

	private void setArtist(String artist) throws InvalidSongException {
		if (artist.length() < 3 || artist.length() > 20) {
			throw new InvalidArtistNameException();
		}
		this.artist = artist;
	}

	private void setName(String name) throws InvalidSongException {
		if (name.length() < 3 || name.length() > 30) {
			throw new InvalidSongNameException();
		}
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	private void setLength(String length) throws InvalidSongException {
		String[] tokens = length.split(":");
		if (tokens.length != 2) {
			throw new InvalidSongLengthException();
		}
		int minutes;
		int seconds;
		try {
			minutes = Integer.parseInt(tokens[0]);
			seconds = Integer.parseInt(tokens[1]);
		} catch (Exception e) {
			throw new InvalidSongLengthException();
		}
		
		if (minutes < 0 || minutes > 14) {
			throw new InvalidSongMinutesException();
		}
		
		if (seconds < 0 || seconds > 59) {
			throw new InvalidSongSecondsException();
		}
		
		this.length = (minutes * 60) + seconds;
	}

}
