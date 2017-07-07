import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BoundedNumbers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		List<Integer> bounds = Arrays.asList(scanner.nextLine()
					.split("\\s+"))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		Arrays.asList(scanner.nextLine()
					.split("\\s+"))
					.stream().map(Integer::parseInt)
				.filter(x -> x >= Collections.min(bounds) 
					&& x <= Collections.max(bounds))
				.forEach(x -> System.out.print(x + " "));
		
		scanner.close();

	}

}
