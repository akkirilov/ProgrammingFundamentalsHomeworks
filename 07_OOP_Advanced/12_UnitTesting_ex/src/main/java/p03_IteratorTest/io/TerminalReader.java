package p03_IteratorTest.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalReader {
	
	private BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	
	public String readLine() {
		try {
			return bfr.readLine();
		} catch (IOException e) {  }
		return null;
	}
	
	public String[] readInput() {
		return this.readLine().split("\\s+");
	}

}
