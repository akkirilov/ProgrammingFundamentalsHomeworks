import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PossibleTriangles {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<Double> currentCheckNums = new ArrayList<>();
		boolean isFound = false;
		
		String[] tokens = scanner.nextLine().split("\\s+");
		while (!tokens[0].equals("End")) {
			currentCheckNums.clear();
			for (int i = 0; i < tokens.length; i++) {
				currentCheckNums.add(Double.parseDouble(tokens[i]));
			}
			
			currentCheckNums = currentCheckNums.stream().sorted().collect(Collectors.toList());
			if (currentCheckNums.get(0) + currentCheckNums.get(1) > currentCheckNums.get(2)) {
				System.out.printf("%.2f+%.2f>%.2f%n", currentCheckNums.get(0), currentCheckNums.get(1), currentCheckNums.get(2));
				isFound = true;
			}
			
			tokens = scanner.nextLine().split("\\s+");
		}
		
		if (!isFound) {
			System.out.println("No");
		}
	}
}