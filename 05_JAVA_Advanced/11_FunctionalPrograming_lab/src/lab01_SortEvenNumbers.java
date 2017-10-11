import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class lab01_SortEvenNumbers {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		Predicate<Integer> isEvenNumber = x -> x % 2 == 0;
		
		List<Integer> inputNumbers = Arrays.stream(bfr.readLine().split(",\\s+"))
				.map(x -> x.trim())
				.map(Integer::parseInt)
				.filter(isEvenNumber)
				.collect(Collectors.toList());
		
		bfr.close();

		System.out.println(inputNumbers.toString().replaceAll("\\[|\\]", ""));
		
		Collections.sort(inputNumbers);
		System.out.println(inputNumbers.toString().replaceAll("\\[|\\]", ""));
		
	}

}
