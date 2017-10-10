import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class ex10_CountSymbols {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		char[] input = bfr.readLine().toCharArray();
		bfr.close();
		
		Map<Character, Integer> counts = new TreeMap<>();
		for (int i = 0; i < input.length; i++) {
			if (counts.containsKey(input[i])) {
				counts.put(input[i], counts.get(input[i]) + 1);
			} else {
				counts.put(input[i], 1);
			}
		}
		
		for (Map.Entry<Character, Integer> pair : counts.entrySet()) {
			System.out.printf("%s: %d time/s%n", pair.getKey(), pair.getValue());
		}
		
	}

}
