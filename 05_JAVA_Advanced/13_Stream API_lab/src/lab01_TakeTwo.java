import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lab01_TakeTwo {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
				.map(Integer::parseInt)
				.distinct()
				.filter(x -> x >= 10 && x <= 20)
				.limit(2)
				.collect(Collectors.toList());
		
		reader.close();
		
		if (numbers.size() == 0) {
			return;
		} else {
			System.out.println(numbers.toString().replaceAll("\\[|\\]|,", ""));
		}

	}

}
