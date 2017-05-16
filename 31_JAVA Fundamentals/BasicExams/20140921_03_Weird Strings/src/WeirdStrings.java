import java.util.Arrays;
import java.util.Scanner;

public class WeirdStrings {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] tokens = Arrays.stream(scanner.nextLine()
					.replaceAll("\\(|\\)|\\||\\s+|\\\\|\\/", "")
					.split("(\\W+|\\d+|_)+"))
				.filter(x -> !x.equals(""))
				.toArray(String[]::new);
		
		int sum1 = 0;
		for (int j = 0; j < tokens[0].length(); j++) {
			sum1 += tokens[0].toLowerCase().charAt(j) - ('a' - 1);
		}
		
		String word1 = "";
		String word2 = "";
		
		int sum2;
		int sumTotal = Integer.MIN_VALUE;
		for (int i = 1; i < tokens.length; i++) {
			sum2 = 0;
			for (int j = 0; j < tokens[i].length(); j++) {
				sum2 += tokens[i].toLowerCase().charAt(j) - ('a' - 1);
			}
			
			if (sum1 + sum2 >= sumTotal) {
				sumTotal = sum1 + sum2;
				word1 = tokens[i - 1];
				word2 = tokens[i];
			}
			
			sum1 = sum2;
		}
		
		System.out.printf("%s%n%s", word1, word2);
	}
}