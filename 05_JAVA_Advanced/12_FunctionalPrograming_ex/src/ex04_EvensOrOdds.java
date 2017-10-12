import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ex04_EvensOrOdds {

	public static void main(String[] args) throws IOException {

		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		Predicate<Integer> evenOrOdd;
		Consumer<Integer> printNum = x -> System.out.printf("%d ", x);
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Integer[] input = Arrays.stream(bfr.readLine().split("\\s+")).map(parseInteger).toArray(Integer[]::new);
		String condition = bfr.readLine();
		bfr.close();
		
		Integer num = input[0];
		Integer bound = input[1];
		if (num > bound) {
			num = bound;
			bound = input[0];
		}
		
		if (condition.equals("odd")) {
			evenOrOdd = x -> x % 2 != 0;
		} else {
			evenOrOdd = x -> x % 2 == 0;
		}
		
		while (num <= bound) {
			if (evenOrOdd.test(num)) {
				printNum.accept(num);
			}
			num++;
		}
		
	}

}
