import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class lab08_BoundedNumbers {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> bounds = Arrays.stream(reader.readLine().split("\\s+"))
				.map(Integer::parseInt)
				.limit(2)
				.sorted()
				.collect(Collectors.toList());
		
		Predicate<Integer> isInRange = 
				x -> x >= bounds.get(0) && x <= bounds.get(1);
		
		Consumer<Integer> printNum = 
				x -> System.out.print(x + " ");
		
		Arrays.stream(reader.readLine().split("\\s+"))
				.map(Integer::parseInt)
				.filter(isInRange)
				.forEach(printNum);
		
		reader.close();
		
		System.out.println();
		
	}

}
