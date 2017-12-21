package hell.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hell.interfaces.InputReader;

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
