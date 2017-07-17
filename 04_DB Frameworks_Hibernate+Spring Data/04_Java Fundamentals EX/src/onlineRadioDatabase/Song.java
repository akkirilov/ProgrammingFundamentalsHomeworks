package onlineRadioDatabase;

public class Song {
	
	public static Integer COUNTER = 0;
	public static long TOTAL_TIME = 0;
	
	private String artist;
	private String name;
	private int minutes;
	private int seconds;
	
	public Song(String artist, String name, String time) throws InvalidSongException {
		this.setArtist(artist);
		this.setName(name);
		this.checkLengthValidity(time);
		this.setMinutes(time);
		this.setSeconds(time);
		COUNTER++;
		TOTAL_TIME += ((this.minutes * 60) + this.seconds);
	}

	private void setArtist(String artist) throws InvalidArtistNameException {
		if (artist.length() < 3 || artist.length() > 20) {
			throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
		}
		this.artist = artist;
	}
	
	private void setName(String name) throws InvalidSongNameException {
		if (name.length() < 3 || name.length() > 30) {
			throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
		}
		this.name = name;
	}
	
	private void setSeconds(String time) throws InvalidSongSecondsException {
		String[] tokens = time.split(":");
        int seconds = Integer.parseInt(tokens[1]);
		if (seconds < 0 || seconds > 59) {
			throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
		}
		this.seconds = Integer.parseInt(tokens[1]);
	}

	private void setMinutes(String time) throws InvalidSongMinutesException{
		String[] tokens = time.split(":");
		int minutes = Integer.parseInt(tokens[0]);
		if (minutes < 0 || minutes > 14) {
			throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
		}
		this.minutes = Integer.parseInt(tokens[0]);
	}

	public String getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

		
	private void checkLengthValidity(String time) throws InvalidSongLengthException {
		String[] tokens = time.split(":");
		try {
            int minutes = Integer.parseInt(tokens[0]);
            int seconds = Integer.parseInt(tokens[1]);
        } catch(NumberFormatException ex) {
            throw new InvalidSongLengthException("Invalid song length.");
        }
    }
	
}
