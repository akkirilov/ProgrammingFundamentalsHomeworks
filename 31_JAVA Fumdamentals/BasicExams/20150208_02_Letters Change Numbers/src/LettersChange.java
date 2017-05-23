import java.util.Scanner;

public class LettersChange {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] tokens = scanner.nextLine().split("\\s+");
		
		char ch;
		int position;
		double number;
		double totalScore = 0.0;
		
		for (int i = 0; i < tokens.length; i++) {
			number = Double.parseDouble(tokens[i].substring(1, tokens[i].length() - 1));
			
			ch = tokens[i].charAt(0);
			position = Character.toLowerCase(ch) - ('a' - 1);
			if (Character.isLowerCase(ch)) {
				number *= position;
			}
			else {
				number /= position;
			}
			
			ch = tokens[i].charAt(tokens[i].length() - 1);
			position = Character.toLowerCase(ch) - ('a' - 1);
			if (Character.isLowerCase(ch)) {
				number += position;
			}
			else {
				number -= position;
			}
			totalScore += number;
		}

		System.out.printf("%.2f%n", totalScore);
	}
}