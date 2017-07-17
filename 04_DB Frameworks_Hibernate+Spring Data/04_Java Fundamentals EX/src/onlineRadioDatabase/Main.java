package onlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InvalidSongException {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		
		List<Song> songs = new ArrayList<Song>();
		for (int i = 0; i < number; i++) {
			
			String[] input = scanner.nextLine().split(";");
			if (input.length != 3) {
				System.out.println(input.length + "Invalid song.");
			}
			else {
				try{
					songs.add(new Song(input[0], input[1], input[2]));
					System.out.println("Song added.");
				} catch (InvalidSongException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		scanner.close();

        long totalDuration = Song.TOTAL_TIME;
        long hours = totalDuration / 3600;
        totalDuration -= hours * 3600;
        long minutes = totalDuration / 60;;
        totalDuration -= minutes * 60;
		long seconds = totalDuration;
		
		System.out.printf("Songs added: %d%nPlaylist length: %dh %dm %ds%n", Song.COUNTER, hours, minutes, seconds);
		
	}

}
