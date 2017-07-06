import java.util.Arrays;
import java.util.Scanner;

public class AverageOfDoubles {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.printf("%.2f%n", Arrays.stream(scanner.nextLine().split("\\s+"))
								.mapToDouble(Double::parseDouble)
								.average()
								.getAsDouble());
		} catch (Exception e) {
			System.out.println("No match");
		}
		
		scanner.close();

	}

}
