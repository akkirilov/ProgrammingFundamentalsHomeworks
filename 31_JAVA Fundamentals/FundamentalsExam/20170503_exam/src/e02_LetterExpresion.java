import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e02_LetterExpresion {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		reader.close();

		Pattern digitP = Pattern.compile("(?<num>(\\d+))");
		Matcher digitM = digitP.matcher(input);
		Pattern charsP = Pattern.compile("(?<chars>[\\D]+)(?<num>(\\d+))");
		Matcher charsM = charsP.matcher(input);
		Double sum = 0d;
		if (digitM.find()) {
			sum = Double.parseDouble(digitM.group("num"));
		} else {
			return;
		}
		
		input = input.substring(sum.toString().length(), input.length());

		while (digitM.find() && charsM.find()) {
			
			Double value = Double.parseDouble(digitM.group("num"));
			Integer count = charsM.group("chars").length();
			if (count % 2 == 0) {
				sum += value;
			} else {
				sum -= value;
			}

		}
		
		if (Long.parseLong(sum.toString().split("\\.")[1]) > 0) {
			System.out.printf("%.7f%n", sum);
		} else {
			System.out.printf("%.0f%n", sum);
		}

	}

}
