import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

public class lab02_SumNumbers {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
				
		String[] inputNumbers = bfr.readLine().split("\\s*,\\s*");
		
		bfr.close();

		Consumer<Integer> printLength = x -> System.out.printf("Count = %d%n", x);
		Consumer<Integer> printSum = x -> System.out.printf("Sum = %d%n", x);
		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);

		printLength.accept(inputNumbers.length);

		Integer sum = 0;
		for (int i = 0; i < inputNumbers.length; i++) {
			sum += parseInteger.apply(inputNumbers[i]);
		}
		
		printSum.accept(sum);
		
	}

}
