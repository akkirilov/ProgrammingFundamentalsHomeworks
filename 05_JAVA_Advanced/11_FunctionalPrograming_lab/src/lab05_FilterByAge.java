import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class lab05_FilterByAge {

	public static void main(String[] args) throws IOException {

		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		BiFunction<Integer, Integer, Boolean> checkAge = (x, y) -> x <= y;
		Function<Map.Entry<String, Integer>, String> toPrint = (x) -> String.format("%s - %d", x.getKey(), x.getValue());
		Consumer<String> print = x -> System.out.println(x);
		
		Map<String, Integer> personData = new LinkedHashMap<>();

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Integer n = parseInteger.apply(bfr.readLine());
		for (; n > 0; n--) {
			String[] tokens = bfr.readLine().split("\\s*,\\s*");
			personData.put(tokens[0], parseInteger.apply(tokens[1]));
		}
		
		String criteria = bfr.readLine();
		Integer age = parseInteger.apply(bfr.readLine());
		String visability = bfr.readLine();
		
		bfr.close();
		
		if (criteria.equals("older")) {
			checkAge = (y, x) -> x <= y;
		}
		
		if (visability.equals("name")) {
			toPrint = (x) -> String.format("%s", x.getKey());
		} else if (visability.equals("age")) {
			toPrint = (x) -> String.format("%d", x.getValue());
		}
		
		for (Map.Entry<String, Integer> pair : personData.entrySet()) {
			if (checkAge.apply(pair.getValue(), age)) {
				print.accept(toPrint.apply(pair));
			}
		}
		
	}

}
