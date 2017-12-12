package p01_Logger.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Reader {

	private static final String SPLIT_DELIMITER = "\\|";

	public String readLine(){
		
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));) {
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
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));) {
			return bfr.readLine().split(SPLIT_DELIMITER);
		} catch (Exception e) {
			return null;
		}
	}
	
}
