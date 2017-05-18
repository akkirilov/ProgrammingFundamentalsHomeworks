import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidUsernames {
	
	private static Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]+$");
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> usernames = Arrays.stream(scanner.nextLine().split("(\\s+|\\(|\\)|\\\\|\\/)"))
				.filter(x -> isValid(x))
				.collect(Collectors.toList());
		
		int printIndex = -1;
		int lengthSum = 0;
		for (int i = 1; i < usernames.size(); i++) {
			if ((usernames.get(i - 1).length() + usernames.get(i).length()) > lengthSum) {
				lengthSum = usernames.get(i - 1).length() + usernames.get(i).length();
				printIndex = i - 1;
			}
		}
		
		System.out.printf("%s%n%s%n", usernames.get(printIndex), usernames.get(printIndex + 1));
	}

	private static boolean isValid(String username) {
		if (username.length() < 3 || username.length() > 25) {
			return false;
		}
		
		if (pattern.matcher(username).find()) {
			return true;
		}
		
		return false;
	}
}