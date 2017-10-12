import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class ex03_CustomMinFunction {

	public static void main(String[] args) throws IOException {

		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		Function<Integer[], Integer> getMinInteger = x -> Arrays.stream(x).min((a, b) -> a.compareTo(b)).orElse(0);
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Integer[] input = Arrays.stream(bfr.readLine().split("\\s+")).map(parseInteger).toArray(Integer[]::new);
		bfr.close();
		
		Integer min = getMinInteger.apply(input);
		System.out.println(min);
		
	}

}
