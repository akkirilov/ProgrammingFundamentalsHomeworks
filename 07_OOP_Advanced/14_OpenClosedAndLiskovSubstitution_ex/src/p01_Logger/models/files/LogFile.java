package p01_Logger.models.files;

import java.io.File;

import p01_Logger.interfaces.CustomFile;
import p01_Logger.io.Writer;

public class LogFile implements CustomFile {
	
	private final static String PATH_TO_FILE = System.getProperty("user.dir") + "//" + "file.txt";
	
	private StringBuilder sb;
	private File file;
	private Writer writer;
	
	public LogFile() {
		this.file = new File(PATH_TO_FILE);
		sb = new StringBuilder();
		this.writer = new Writer();
	}

	@Override
	public void writeLine(String line) {
		sb.append(line).append(System.lineSeparator());
		writer.WriteLineInFile(this.file, line);
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
