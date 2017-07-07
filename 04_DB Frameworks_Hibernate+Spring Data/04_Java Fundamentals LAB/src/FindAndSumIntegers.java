import java.util.Arrays;
import java.util.Scanner;

public class FindAndSumIntegers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.printf("%d%n", Arrays.stream(scanner.nextLine().split("\\s+"))
								.filter(x -> isNumber(x))
								.mapToInt(Integer::parseInt)
								.reduce(0, (a, b) -> a + b));
		} catch (Exception e) {
			System.out.println("No match");
		} finally {
			scanner.close();
		}

	}

	private static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
