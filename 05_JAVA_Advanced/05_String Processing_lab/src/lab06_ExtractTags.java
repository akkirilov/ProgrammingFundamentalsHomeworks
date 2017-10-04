import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab06_ExtractTags {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
				
		String input = scanner.nextLine();

        StringBuilder text = new StringBuilder();
        while (!input.equals("END")) {
            text.append(input);
            input = scanner.nextLine();
        }
        scanner.close();

        Pattern pattern = Pattern.compile("<.+?>");
        Matcher matcher = pattern.matcher(text.toString());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
				
	}

}
