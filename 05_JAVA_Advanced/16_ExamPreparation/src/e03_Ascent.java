import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e03_Ascent {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> memo = new LinkedHashMap<>();
		String decoded = "";
		Pattern pattern = Pattern.compile("([,_][a-zA-Z]+\\d)");
		String input = reader.readLine();
		Matcher matcher = pattern.matcher(input);
		while (!input.equals("Ascend")) {

			for (Map.Entry<String, String> s : memo.entrySet()) {
				input = input.replaceAll(s.getKey(), s.getValue());
			}
			
			matcher = pattern.matcher(input);
			while (matcher.find()) {
				String word = matcher.group();
				if (word.charAt(0) == '_') {
					decoded = underDecode(word);
				} else {
					decoded = comaDecode(word);
				}
				input = input.replace(word, decoded);
				memo.put(word, decoded);
			}

			System.out.println(input);

			input = reader.readLine();

		}
		reader.close();

	}

	private static String underDecode(String word) {
		int digit = Integer.parseInt(word.charAt(word.length() - 1) + "");
		StringBuilder toReturn = new StringBuilder();
		for (int i = 1; i < word.length() - 1; i++) {
			toReturn.append((char) (word.charAt(i) - digit));
		}
		return toReturn.toString();
	}

	private static String comaDecode(String word) {
		int digit = Integer.parseInt(word.charAt(word.length() - 1) + "");
		StringBuilder toReturn = new StringBuilder();
		for (int i = 1; i < word.length() - 1; i++) {
			toReturn.append((char) (word.charAt(i) + digit));
		}
		return toReturn.toString();
	}

}
