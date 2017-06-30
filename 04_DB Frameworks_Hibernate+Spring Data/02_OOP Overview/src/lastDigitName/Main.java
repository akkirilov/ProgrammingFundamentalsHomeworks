package lastDigitName;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		System.out.println(Number.getDigitInAlphabet(number % 10));

	}

}
