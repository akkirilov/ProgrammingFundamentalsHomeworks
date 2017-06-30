import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VowelOrDigit {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		char input = scanner.nextLine().charAt(0);
		scanner.close();
		
		List<Character> vowels = new ArrayList<>(Arrays.asList('e','o','u','i','a','y'));
		
		if (vowels.contains(input)) {
			System.out.println("vowel");
		} else if (input >= '0' && input <= '9') {
			System.out.println("digit");
		} else {
			System.out.println("other");
		}
		
	}

}
