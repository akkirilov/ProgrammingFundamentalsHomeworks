import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ex12_MinerTask {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> resources = new LinkedHashMap<>();
		while (true) {
			
			String name = bfr.readLine();
			if (name.equals("stop")) {
				break;
			}
			
			Integer quantity = Integer.parseInt(bfr.readLine());
			if (resources.containsKey(name)) {
				resources.put(name, resources.get(name) + quantity);
			} else {
				resources.put(name, quantity);
			}
						
		}
		
		bfr.close();
		
		for (Map.Entry<String, Integer> pair : resources.entrySet()) {
			System.out.printf("%s -> %d%n", pair.getKey(), pair.getValue());
		}
		
	}

}
