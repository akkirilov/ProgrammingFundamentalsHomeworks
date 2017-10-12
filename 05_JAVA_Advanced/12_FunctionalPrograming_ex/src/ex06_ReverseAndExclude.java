import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ex06_ReverseAndExclude {

	public static void main(String[] args) throws IOException {
		
		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		Consumer<List<Integer>> printList = x -> System.out.println(x.toString().replaceAll("\\[|\\]|,", ""));
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> input = Arrays.stream(bfr.readLine().split("\\s+")).map(parseInteger).collect(Collectors.toList());
		Integer divider = parseInteger.apply(bfr.readLine());
		bfr.close();
		
		Predicate<Integer> isNotDividable = x -> x % divider != 0;
		Collections.reverse(input);
		input = input.stream().filter(isNotDividable).collect(Collectors.toList());
		
		printList.accept(input);
		
	}

}
