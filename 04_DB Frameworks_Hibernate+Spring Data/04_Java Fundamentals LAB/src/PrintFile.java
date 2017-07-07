import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;


public class PrintFile {

	public static void main(String[] args) {
		
		String path1 = System.getProperty("user.dir") + "\\src\\file1.txt";
		String path2 = System.getProperty("user.dir") + "\\src\\file2.txt";
		
		File file1 = new File(path1);
		File file2 = new File(path2);
		
		fillContent(file1);
		
		copyFile(file1, file2);
		
		printFile(file2);
		
	}

	private static void printFile(File file2) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(file2);
						
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (Exception e) {
			System.out.println("Error during print!");
		} finally {
			try { scanner.close(); } catch (Exception ex) {  }
		}
	}

	private static void copyFile(File file1, File file2) {
		Scanner scanner = null;
		Writer writer = null;
		try {
			scanner = new Scanner(file1);
			
			try {
				writer = new BufferedWriter(new OutputStreamWriter(
			    		new FileOutputStream(file2), "utf-8"));
			} catch (Exception e) {	 }
			
			while (scanner.hasNextLine()) {
				writer.write(scanner.nextLine() + "\r\n");
			}
		} catch (Exception e) {
			System.out.println("Error during copy!");
		} finally {
			try { writer.close(); } catch (Exception ex) {  }
			try { scanner.close(); } catch (Exception ex) {  }
		}
		
	}

	private static void fillContent(File file1) {
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		    		new FileOutputStream(file1), "utf-8"));
		    for (int i = 1; i <= 50; i++) {
		    	writer.write("Some test " + i + "\r\n");
			}
		} catch (IOException ex) {
		  	System.out.println("Error during write!");
		} finally {
			try { writer.close(); } catch (Exception ex) {  }
		}
		
	}

}
