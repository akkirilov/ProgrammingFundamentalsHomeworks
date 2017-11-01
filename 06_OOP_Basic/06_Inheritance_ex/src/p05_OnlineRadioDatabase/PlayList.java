package p05_OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
	
	List<Song> songs;

	public PlayList() {
		super();
		this.songs = new ArrayList<>();
	}
	
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	public String getTotalLength() {
		long totalSeconds = 0L;
		for (Song s : songs) {
			totalSeconds += s.getLength();
		}
		long hours = totalSeconds / (60 * 60);
		if (hours <= 0) {
			hours = 0L;
		} else {
			totalSeconds %= (60 * 60);
		}
		String res = hours + "h ";
		long minutes = (totalSeconds / 60);
		if (minutes <= 0) {
			minutes = 0L;
		} else {
			totalSeconds %= 60;
		}
		res += minutes + "m ";
		return res + totalSeconds + "s";
	}
	
	public int countSongs() {
		return this.songs.size();
	}
	
}
