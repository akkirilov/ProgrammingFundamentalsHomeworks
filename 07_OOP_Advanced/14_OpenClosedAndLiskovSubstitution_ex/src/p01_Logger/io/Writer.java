package p01_Logger.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Writer {
	
	public void WriteLine(String string) {
		System.out.println(string);
	}
	
	public void WriteLineInFile(File file, String line) {
		try {
			BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "utf-8"));
			bfw.append(line);
			bfw.newLine();
			bfw.close();
		} catch (IOException e) {
			
		}
	}

}
