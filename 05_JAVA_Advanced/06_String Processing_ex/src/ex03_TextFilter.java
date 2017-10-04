import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex03_TextFilter {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String[] bannedWords = bfr.readLine().split(",\\s+");
		String text = bfr.readLine();
		
		bfr.close();
		
		for (int i = 0; i < bannedWords.length; i++) {
			text = text.replaceAll(bannedWords[i], bannedWords[i].replaceAll("\\w", "*"));
		}
		
		System.out.println(text);
		
	}

}
