import java.util.Scanner;

public class lab04_SeriesOfLetters {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.nextLine().toCharArray();
		scanner.close();
		
		char lastChar = input[0];
		
		StringBuffer output = new StringBuffer();
		output.append(lastChar);
		
		for (int i = 1; i < input.length; i++) {
			if (input[i] == lastChar ) {
				continue;
			} else {
				lastChar = input[i];
				output.append(input[i]);
			}
		}
		
		System.out.println(output.toString());

	}

}
