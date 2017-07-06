import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstName {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		String letter = scanner.nextLine().toLowerCase();
		scanner.close();
		
		String output = Arrays.stream(input)
						.filter(x -> x.toLowerCase().startsWith(letter))
						.sorted()
						.limit(1)
						.collect(Collectors.joining(""));
		
		if (output.isEmpty()) {
			System.out.println("No match");
		} else {
			System.out.println(output);
		}
		
	}

}
