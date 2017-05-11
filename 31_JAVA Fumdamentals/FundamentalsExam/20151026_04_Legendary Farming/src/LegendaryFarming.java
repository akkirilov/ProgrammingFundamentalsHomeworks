import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LegendaryFarming {
	
	public static void main(String[] args) {
		Map<String, Integer> junks = new TreeMap<>();
		
		Map<String, Integer> materials = new HashMap<>();
		materials.put("shards", 0);
		materials.put("fragments", 0);
		materials.put("motes", 0);
		
		int quantity;
		String item = "";
		
		boolean enough = false;
				
		Scanner scanner = new Scanner(System.in);
		String[] tokens = scanner.nextLine().split(" "); 
		while (true) {
			for (int i = 0; i < tokens.length; i += 2) {
				quantity = Integer.parseInt(tokens[i]);
				item = tokens[i + 1].toLowerCase();
				
				if (materials.containsKey(item)) {
					materials.put(item, materials.get(item) + quantity);
					
					if (materials.get(item) >= 250){
						materials.put(item, materials.get(item) - 250);
						enough = true;
						break;
					}
				}
				else if (junks.containsKey(item)) {
					junks.put(item, junks.get(item) + quantity);
				}
				else {
					junks.put(item, quantity);
				}
			}
			
			if (enough) {
				break;
			}
			
			tokens = scanner.nextLine().toLowerCase().split("\\s+"); 
		}
			
		if (item.equals("shards")) {
			System.out.println("Shadowmourne obtained!");
		}
		else if (item.equals("motes")) {
			System.out.println("Dragonwrath obtained!");
		}
		else {
			System.out.println("Valanyr obtained!");
		}
		
		List<Entry<String, Integer>> list = materials
		        .entrySet()
		        .stream()
		        .sorted((Entry<String, Integer> o1, Entry<String, Integer> o2) -> {
		             return o1.getValue().equals(o2.getValue()) ? 
		            		 o1.getKey().compareTo(o2.getKey()) 
		            		 : o2.getValue().compareTo(o1.getValue());
		        	})
		        .collect(Collectors.toList());
		
		for (Entry<String, Integer> entry : list) {
			System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
		}
		
		for (Map.Entry<String, Integer> entry : junks.entrySet()) {
			System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
		}
	}
}