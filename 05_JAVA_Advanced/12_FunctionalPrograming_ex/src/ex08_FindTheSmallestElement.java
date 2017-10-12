import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ex08_FindTheSmallestElement {

	public static void main(String[] args) throws IOException {
		
		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		Function<List<Integer>, Integer> findSmallestIndex = x -> {
			Integer min = Integer.MAX_VALUE;
			Integer index = -1;
			for (int i = 0; i < x.size(); i++) {
				if (x.get(i) <= min) {
					min = x.get(i);
					index = i;
				}
			}
			return index;
		};
		Consumer<Integer> printList = x -> System.out.println(x);
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> input = Arrays.stream(bfr.readLine().split("\\s+")).map(parseInteger).collect(Collectors.toList());
		bfr.close();
		
		Integer index = findSmallestIndex.apply(input);
		printList.accept(index);
		
	}

}
