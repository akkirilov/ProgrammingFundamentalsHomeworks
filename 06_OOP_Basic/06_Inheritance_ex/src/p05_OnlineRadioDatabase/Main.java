package p05_OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		PlayList playList = new PlayList();
		
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			
			String[] tokens = reader.readLine().split(";");
			try {
				Song tempSong = new Song(tokens[0], tokens[1], tokens[2]);
				playList.addSong(tempSong);
				System.out.println("Song added.");
			} catch (InvalidSongException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		reader.close();

		System.out.println("Songs added: " + playList.countSongs());
		System.out.println("Playlist length: " + playList.getTotalLength());
		
	}

}
