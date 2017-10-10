import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ex15_LegendaryFarming {

	public static void main(String[] args) throws IOException {
		
		Map<String, Long> keyMaterials = new HashMap<>();
		keyMaterials.put("shards", 0L);
		keyMaterials.put("fragments", 0L);
		keyMaterials.put("motes", 0L);
		
		Map<String, Long> junkMaterials = new HashMap<>();
		
		Boolean isObtained = false;
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			
			String[] input = bfr.readLine().split("\\s+");
			
			for (int i = 0; i < input.length; i += 2) {
				
				String material = input[i + 1].toLowerCase();
				Long quantity = Long.parseLong(input[i]);
				
				if (keyMaterials.containsKey(material)) {
					keyMaterials.put(material, keyMaterials.get(material) + quantity);
					if (keyMaterials.get(material) >= 250) {
						String object = "";
						if (material.equals("fragments")) {
							object = "Valanyr";
						} else if (material.equals("motes")) {
							object = "Dragonwrath";
						} else if (material.equals("shards")) {
							object = "Shadowmourne";
						}
						keyMaterials.put(material, keyMaterials.get(material) - 250);
						isObtained = true;
						System.out.println(object + " obtained!");
					}
				} else {
					if (junkMaterials.containsKey(material)) {
						junkMaterials.put(material, junkMaterials.get(material) + quantity);
					} else {
						junkMaterials.put(material, quantity);
					}
				}
				if (isObtained) {
					break;
				}
			}
			if (isObtained) {
				break;
			}
		}
		bfr.close();
		
		keyMaterials = keyMaterials
				.entrySet()
				.stream()
				.sorted((a, b) -> {
					int res = b.getValue().compareTo(a.getValue());
					if (res == 0) {
						res = a.getKey().compareTo(b.getKey());
					}
					return res;
				}
				)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		for (Map.Entry<String, Long> pair : keyMaterials.entrySet()) {
			System.out.printf("%s: %d%n", pair.getKey(), pair.getValue());
		}
		
		junkMaterials = junkMaterials
				.entrySet()
				.stream()
				.sorted((a, b) -> {
					int res = a.getKey().compareTo(b.getKey());
					if (res == 0) {
						res = b.getValue().compareTo(a.getValue());
					}
					return res;
				}
				)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		for (Map.Entry<String, Long> pair : junkMaterials.entrySet()) {
			System.out.printf("%s: %d%n", pair.getKey(), pair.getValue());
		}
	}

}
