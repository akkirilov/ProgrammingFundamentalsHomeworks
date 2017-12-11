package p02_FileStream;

public class Main {

	public static void main(String[] args) {
		
		Streamable file = new File("fileName", 10, 5);
		Streamable music = new Music("artistName", "albumName", 10, 5);
		
		StreamProgressInfo progressFile = new StreamProgressInfo(file);
		System.out.println(progressFile.calculateCurrentPercent());
		
		StreamProgressInfo progressMusic = new StreamProgressInfo(music);
		System.out.println(progressMusic.calculateCurrentPercent());

	}

}
