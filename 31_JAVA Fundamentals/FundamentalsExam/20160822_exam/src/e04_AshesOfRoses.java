import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e04_AshesOfRoses {

	public static void main(String[] args) throws IOException {

		LinkedHashMap<String, LinkedHashMap<String, BigInteger>> roses = new LinkedHashMap<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String region;
		String color;
		BigInteger amount;
		Pattern pattern = Pattern
				.compile("\\AGrow\\s<(?<region>[A-Z][a-z]+)>\\s<(?<color>[a-zA-Z0-9]+)>\\s(?<amount>[0-9]+)\\Z");
		Matcher matcher;
		LinkedHashMap<String, BigInteger> temp = new LinkedHashMap<>();
		String input = reader.readLine();
		while (!input.equals("Icarus, Ignite!")) {

			matcher = pattern.matcher(input);
			if (!matcher.find()) {
				input = reader.readLine();
				continue;
			}

			region = matcher.group("region");
			color = matcher.group("color");
			amount = new BigInteger(matcher.group("amount"));

			if (roses.containsKey(region)) {
				temp = roses.get(region);
				if (temp.containsKey(color)) {
					amount = amount.add(temp.get(color));
				}
			} else {
				temp = new LinkedHashMap<>();
			}

			temp.put(color, amount);
			roses.put(region, temp);
			
			input = reader.readLine();

		}

		reader.close();

		roses.entrySet()
			.stream()
			.sorted((a, b) -> {
				int res = countTotalAmount(b).compareTo(countTotalAmount(a));
				if (res == 0) {
					res = a.getKey().compareTo(b.getKey());
				}
				return res;
			})
			.forEach(x -> {
				System.out.println(x.getKey());
				x.getValue()
				.entrySet()
				.stream()
				.sorted((a, b) -> {
					int res = a.getValue().compareTo(b.getValue());
					if (res == 0) {
						res = a.getKey().compareTo(b.getKey());
					}
					return res;
				})
				.forEach(l -> System.out.printf("*--%s | %d%n", l.getKey(), l.getValue()));
			});

	}

	private static BigInteger countTotalAmount(Entry<String, LinkedHashMap<String, BigInteger>> entry) {
		
		BigInteger res = BigInteger.ZERO;
		for (Map.Entry<String, BigInteger> s : entry.getValue().entrySet()) {
			res = res.add(s.getValue());
		}
		return res;
		
	}

}
