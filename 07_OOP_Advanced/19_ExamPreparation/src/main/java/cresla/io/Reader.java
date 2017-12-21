package cresla.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cresla.interfaces.InputReader;

public class Reader implements InputReader {

	private BufferedReader bfr;
	
	public Reader(InputStreamReader is) {
		this.bfr = new BufferedReader(is);
	}

	@Override
	public String readLine() {
		try {
			return this.bfr.readLine();
		} catch (IOException e) {
			return null;
		}
	}

}
