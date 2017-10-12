import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ex07_PredicateForNames {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		Integer length = parseInteger.apply(bfr.readLine());
		Predicate<String> checkLength = x -> x.length() <= length;
		
		List<String> input = Arrays.stream(bfr.readLine().split("\\s+")).filter(checkLength).collect(Collectors.toList());
		
		bfr.close();

		Consumer<List<String>> printList = x -> System.out.println(x.toString().replaceAll("\\[|\\]|,", "").replaceAll("\\s", "\r\n"));
		printList.accept(input);
		
	}

}
