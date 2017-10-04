import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex04_UnicodeCharacters {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		char[] chars = bfr.readLine().toCharArray();
		
		bfr.close();
		
		for (int i = 0; i < chars.length; i++) {
			System.out.print("\\u00" + Integer.toHexString(chars[i]));
		}
		
		System.out.println();
		
	}

}
