import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ex06_SimpleTextEditor {

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(bfr.readLine());

		String text = "";
		Deque<String> allTexts = new ArrayDeque<>();
		allTexts.push(text);
		for (int i = 0; i < n; i++) {

			String input = bfr.readLine();
			String[] tokens = input.split("\\s+");

			switch (tokens[0]) {
			case "1":
				text += tokens[1];
				allTexts.push(text);
				break;
			case "2":
				text = text.substring(0, text.length() - Integer.parseInt(tokens[1]));
				allTexts.push(text);
				break;
			case "3":
				System.out.println(text.charAt(Integer.parseInt(tokens[1]) - 1));
				break;
			case "4":
				if (allTexts.size() > 1) {
					allTexts.pop();
					text = allTexts.pop();
					allTexts.push(text);
				}
				break;
			default:
				break;
			}

		}

		bfr.close();

	}

}
