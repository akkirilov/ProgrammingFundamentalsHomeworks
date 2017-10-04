import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab05_VowelCount {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		Pattern pattern = Pattern.compile("[AUEIOYaueioy]");
		Matcher matcher = pattern.matcher(input);
		
		Integer counter = 0;
		while (matcher.find()) {
			counter++;
		}
		
		System.out.println("Vowels: " + counter);
		
	}

}
