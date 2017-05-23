import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class OfficeStuff {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		List<String> temp = new ArrayList<>();
		Map<String, LinkedHashMap<String, Integer>> companies = new TreeMap<>();
		
		int amount = 0;
		String company = "";
		String product = "";
		for (int i = 0; i < n; i++) {
			temp = Arrays.stream(scanner.nextLine().split("\\||\\s+-\\s+"))
					.filter(x -> !x.equals(""))
					.collect(Collectors.toList());
			
			company = temp.get(0);
			amount = Integer.parseInt(temp.get(1));
			product = temp.get(2);
			if (companies.containsKey(company)) {
				if (companies.get(company).containsKey(product)) {
					companies.get(company).put(product, companies.get(company).get(product) + amount);
				}
				else {
					companies.get(company).put(product, amount);
				}
			}
			else {
				companies.put(company, new LinkedHashMap<>());
				companies.get(company).put(product, amount);
			}
		}
			
		for (Map.Entry<String, LinkedHashMap<String, Integer>> companiesEntry : companies.entrySet()) {
			System.out.printf("%s: ", companiesEntry.getKey());
			
			temp.clear();
			for (Map.Entry<String, Integer> productsEntry : companiesEntry.getValue().entrySet()) {
				temp.add(productsEntry.getKey() + "-" + productsEntry.getValue());
			}
		
			System.out.println(String.join(", ", temp));
		}
	}
}