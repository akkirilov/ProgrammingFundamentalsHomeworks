import java.util.Arrays;
import java.util.Scanner;

public class ex08_GetFirstOddOrEven {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
				.map(x -> x.trim())
				.mapToInt(Integer::parseInt)
				.toArray();
		String type = scanner.next();
		Integer counter = scanner.nextInt();
		type = scanner.next();

		scanner.close();
		
		Integer checker = 0;
		if (type.equals("odd")) {
			checker = 1;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if (Math.abs(numbers[i] % 2) == checker) {

				if (counter <= 0) {
					break;
				}
				
				System.out.print(numbers[i] + " ");
				counter--;

			}
			
		}

	}

}
