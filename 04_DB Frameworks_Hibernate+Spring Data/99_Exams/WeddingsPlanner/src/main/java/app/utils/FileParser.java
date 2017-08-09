package app.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.springframework.stereotype.Component;

@Component
public class FileParser {
	
	public String readFile(String path) throws IOException {
		
		StringBuilder content = new StringBuilder();
		try (
				InputStream in = getClass().getResourceAsStream(path);
				BufferedReader bfr = new BufferedReader(new InputStreamReader(in, "UTF8"))
				) {
			
			String line = null;
            while ((line = bfr.readLine()) != null) {
                content.append(line);
            }
		}
		return content.toString();
	}
	
	public void writeFile (String path, String content) throws FileNotFoundException, IOException {
		
		File file = new File(path);
        if(!file.exists()) {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        
		try (OutputStream out = new FileOutputStream(path);
				BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(out));) {
			bfw.write(String.valueOf(content));
		}
		
	}

}
