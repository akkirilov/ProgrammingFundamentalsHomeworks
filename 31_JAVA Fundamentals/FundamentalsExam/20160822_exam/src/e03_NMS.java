import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e03_NMS {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder text = new StringBuilder();
		String input = reader.readLine();
		while (!input.equals("---NMS SEND---")) {
			
			text.append(input);
			
			input = reader.readLine();
			
		}
		
		String delimiter = reader.readLine();
		
		reader.close();

		StringBuilder words = new StringBuilder();
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			
			if (i == text.length() - 1) {
				if (Character.toLowerCase(text.charAt(i - 1)) <= Character.toLowerCase(text.charAt(i))) {
					word.append(text.charAt(i));
					words.append(word.toString());
				} else if (Character.toLowerCase(text.charAt(i - 1)) > Character.toLowerCase(text.charAt(i))
						&&  word.length() == 0) {
					words.append(word.toString());
					words.append(text.charAt(i));
				} else {
					words.append(word.toString() + delimiter);
					words.append(text.charAt(i));
				}
				break;
			}

			if (Character.toLowerCase(text.charAt(i)) <= Character.toLowerCase(text.charAt(i + 1))) {
				word.append(text.charAt(i));
			} else if (Character.toLowerCase(text.charAt(i)) > Character.toLowerCase(text.charAt(i + 1))
					&& word.length() == 0) {
				words.append(text.charAt(i) + delimiter);
			} else {
				word.append(text.charAt(i));
				words.append(word.toString() + delimiter);
				word = new StringBuilder();
			}

		}

		System.out.println(words.toString());

	}

}
