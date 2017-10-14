import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class lab06_FindAndSumIntegers {

	public static void main(String[] args) throws IOException {
		
		Predicate<String> isInteger = x -> {
			try {
				Integer.parseInt(x);
				return true;
			} catch (Exception e) {
				return false;
			}
		};
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<String> collection = Arrays.stream(reader.readLine().split("\\s+"))
				.filter(isInteger)
				.collect(Collectors.toList());
		
		reader.close();

		if (collection.size() == 0) {
			System.out.println("No match");
		} else {
			Integer sum = collection.stream()
					.mapToInt(Integer::parseInt)
					.sum();
			System.out.println(sum);
		}

	}

}
