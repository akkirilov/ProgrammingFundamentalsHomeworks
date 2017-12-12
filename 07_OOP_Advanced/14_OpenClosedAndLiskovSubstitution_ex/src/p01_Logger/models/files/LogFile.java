package p01_Logger.models.files;

import java.io.File;

import p01_Logger.interfaces.CustomFile;
import p01_Logger.io.Writer;

public class LogFile implements CustomFile {
	
	private StringBuilder sb;
	private Writer writer;
	
	public LogFile() {
		this.sb = new StringBuilder();
		this.writer = new Writer();
	}

	@Override
	public void writeLine(String line) {
		sb.append(line).append(System.lineSeparator());
	}

	@Override
	public Long getSize() {
		long size = 0L;
		for (Character  ch : sb.toString().toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				size += ch;
			}
		}
		return size;
	}

}
