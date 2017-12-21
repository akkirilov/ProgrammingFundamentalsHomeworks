package app.waste_disposal.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import app.waste_disposal.contracts.InputReader;

public class Reader implements InputReader {

	private BufferedReader reader;

	public Reader(InputStreamReader is) {
		this.reader = new BufferedReader(is);
	}

	@Override
	public String readLine() {
		try {
			return this.reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
