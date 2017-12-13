package p02_Blob.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Reader {

	private static final String SPLIT_DELIMITER = "\\|";
	
	private BufferedReader bfr;
	
	public Reader(BufferedReader bfr) {
		this.bfr = bfr;
	}

	public String readLine(){
		try {
			return bfr.readLine();
		} catch (Exception e) {
			return null;
		}
	}
	
	public String[] readFileLines(File file){
		try(BufferedReader bfr = new BufferedReader(new FileReader(file));) {
			return bfr.lines().toArray(String[]::new);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String[] readCommands(){
		try {
			return bfr.readLine().split(SPLIT_DELIMITER);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String[] readCommands(String delimiter){
		try {
			return bfr.readLine().split(delimiter);
		} catch (Exception e) {
			return null;
		}
	}
	
}
