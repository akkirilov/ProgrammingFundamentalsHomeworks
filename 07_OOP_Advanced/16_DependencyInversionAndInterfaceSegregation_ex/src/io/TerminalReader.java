package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import contracts.Reader;

public class TerminalReader implements Reader {
	
	BufferedReader bfr;

	public TerminalReader() {
		this(new InputStreamReader(System.in));
	}
	
	public TerminalReader(InputStreamReader in) {
		this.bfr = new BufferedReader(in);
	}

	@Override
	public String readLine() {
		try {
			return bfr.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void close() {
		try {
			this.bfr.close();
		} catch (IOException e) {  }
	}

}
