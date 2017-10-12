import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ex09_CustomComparator {

	public static void main(String[] args) throws IOException {
		
		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		Comparator<Integer> intSort = (a, b) -> a.compareTo(b);
		Predicate<Integer> evenFilter = x -> x % 2 == 0;
		Predicate<Integer> oddFilter = x -> x % 2 != 0;
		Consumer<Integer[]> printArr = x -> System.out.print(Arrays.toString(x).replaceAll("\\[|\\]|,", "") + " ");
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Integer[] input = Arrays.stream(bfr.readLine().split("\\s+"))
				.map(parseInteger)
				.toArray(Integer[]::new);
		bfr.close();

		Integer[] even = Arrays.stream(input)
				.filter(evenFilter)
				.sorted(intSort)
				.toArray(Integer[]::new);
		Integer[] odd = Arrays.stream(input)
				.filter(oddFilter)
				.sorted(intSort)
				.toArray(Integer[]::new);
		
		printArr.accept(even);
		printArr.accept(odd);
		
	}

}
