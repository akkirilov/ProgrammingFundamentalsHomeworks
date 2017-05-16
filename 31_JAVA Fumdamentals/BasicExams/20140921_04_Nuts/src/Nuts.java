import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Nuts {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		
		Map<String, LinkedHashMap<String, Integer>> orders = new TreeMap<>();
		
		String company = "";
		String nutsType = "";
		int amount = 0;
		
		for (int i = 0; i < n; i++) {
			String[] tokens = scanner.nextLine().split("\\s+");
			company = tokens[0];
			nutsType = tokens[1];
			amount = Integer.parseInt(tokens[2].substring(0, tokens[2].length() - 2));
			
			if (orders.containsKey(company)) {
				if (orders.get(company).containsKey(nutsType)) {
					orders.get(company).put(nutsType, orders.get(company).get(nutsType) + amount);
				}
				else {
					orders.get(company).put(nutsType, amount);
				}
			}
			else {
				orders.put(company, new LinkedHashMap<String, Integer>());
				orders.get(company).put(nutsType, amount);
			}
		}
		
		List<String> nutsList = new ArrayList<>();
		
		for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : orders.entrySet()) {
			System.out.printf("%s: ", entry.getKey());
			
			nutsList.clear();
			for (Map.Entry<String, Integer> nuts : entry.getValue().entrySet()) {
				nutsList.add(String.format("%s-%dkg", nuts.getKey(), nuts.getValue()));
			}
			System.out.println(String.join(", ", nutsList));
		}
	}
}