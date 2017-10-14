import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class lab07_MapDistricts {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<String> collection = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
		Integer minPopulation = Integer.parseInt(reader.readLine());
		
		reader.close();
		
		Map<String, List<Integer>> population = new LinkedHashMap<>();
		for (String s : collection) {
			
			String[] tokens = s.split(":");
			
			List<Integer> temp = new ArrayList<>();
			if (population.containsKey(tokens[0])) {
				temp = population.get(tokens[0]);
			}
			
			temp.add(Integer.parseInt(tokens[1]));

			population.put(tokens[0], temp);
		}
		
		Predicate<Map.Entry<String, List<Integer>>> isPopulationEnought = 
				x -> x.getValue().stream().mapToInt(Integer::valueOf).sum() > minPopulation;
				
		Comparator<Map.Entry<String, List<Integer>>> sortMapDescByValues = (a, b) -> {
			return Integer.compare(b.getValue().stream().mapToInt(Integer::valueOf).sum(), 
					a.getValue().stream().mapToInt(Integer::valueOf).sum());
		};
		
		Consumer<Map.Entry<String, List<Integer>>> sortValuesAndPrint = x -> {
			System.out.print(x.getKey() + ": ");
			x.getValue()
				.stream()
				.sorted((a, b) -> b.compareTo(a))
				.limit(5)
				.forEach(a -> System.out.print(a + " "));
			System.out.println();
		};
		
		population.entrySet()
				.stream()
				.filter(isPopulationEnought)
				.sorted(sortMapDescByValues)
				.forEach(sortValuesAndPrint);
				
	}

}
