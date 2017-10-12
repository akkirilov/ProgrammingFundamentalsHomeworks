import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class ex10_ListOfPredicates {

	public static void main(String[] args) throws IOException {
		
		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		Consumer<Integer> printInteger = x -> System.out.print(x + " ");
		BiFunction<Integer, Integer[], Boolean> isDivisible = (x, y) -> {
			for (int i = 0; i < y.length; i++) {
				if (x % y[i] != 0) {
					return false;
				}
			}
			return true;
		};
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Integer num = parseInteger.apply(bfr.readLine());
		Integer[] dividers = Arrays.stream(bfr.readLine().split("\\s+"))
				.map(parseInteger)
				.distinct()
				.toArray(Integer[]::new);
		bfr.close();
		
		for (int i = 1; i <= num; i++) {
			if (isDivisible.apply(i, dividers)) {
				printInteger.accept(i);
			}
		}

	}

}
