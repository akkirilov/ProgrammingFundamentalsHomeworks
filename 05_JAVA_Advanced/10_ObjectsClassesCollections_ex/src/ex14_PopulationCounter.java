import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ex14_PopulationCounter {

	private static Map<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bfr.readLine().split("\\|");
		while (!input[0].equals("report")) {
			
			LinkedHashMap<String, Long> temp = new LinkedHashMap<>();
			temp.put(input[0], Long.parseLong(input[2]));
			if (countries.containsKey(input[1])) {
				temp.putAll(countries.get(input[1]));
			}
			countries.put(input[1], temp);
			input = bfr.readLine().split("\\|");
		}
		bfr.close();
		
		countries = countries
				.entrySet()
				.stream()
                .sorted((a, b) -> {
                    Long operand1 = b.getValue().values().stream().mapToLong(v -> v).sum();
                    Long operand2 = a.getValue().values().stream().mapToLong(v -> v).sum();
                    return operand1.compareTo(operand2);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		for (Map.Entry<String, LinkedHashMap<String, Long>> pair : countries.entrySet()) {
			
			LinkedHashMap<String, Long> cities = pair.getValue()
					.entrySet()
					.stream()
					.sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
			
			System.out.printf("%s (total population: %d)%n", pair.getKey(), countCountryPopulation(pair));
			
			for (Map.Entry<String, Long> city : cities.entrySet()) {
				System.out.printf("=>%s: %d%n",  city.getKey(), city.getValue());
			}
			
		}
		
	}

	private static Long countCountryPopulation(Entry<String, LinkedHashMap<String, Long>> e) {
		Long res = 0L;
		for (Map.Entry<String, Long> pair : e.getValue().entrySet()) {
			res += pair.getValue();
		}
		return res;
	}

}
