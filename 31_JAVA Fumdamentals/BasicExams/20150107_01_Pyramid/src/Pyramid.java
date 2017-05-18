import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pyramid {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		List<Integer> numbers = new ArrayList<>(); 
		List<String> sequence = new ArrayList<>();
		
		boolean found;
		int last = Integer.MIN_VALUE;
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			found = false;
			
			numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
					.filter(x -> !x.equals(""))
					.map(Integer::parseInt)
					.sorted()
					.collect(Collectors.toList());
			
			for (Integer num : numbers) {
				if (num > last) {
					sequence.add(num.toString());
					last = num;
					found = true;
					break;
				}
			}
			
			if (!found) {
				last++;
			}
		}
		
		System.out.println(String.join(", ", sequence));
	}
}