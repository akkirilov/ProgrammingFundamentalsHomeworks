import java.util.Arrays;
import java.util.Scanner;

public class UpperStrings {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Arrays.stream(scanner.nextLine().split("\\s+"))
					.map(String::toUpperCase)
					.forEach(x -> System.out.print(x + " "));
		
		scanner.close();

	}

}
