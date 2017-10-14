import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ex13_OfficeStuff {

	public static void main(String[] args) throws IOException {
		
		TreeMap<String, LinkedHashMap<String, Long>> companies = new TreeMap<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Integer n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			
			String[] tokens = reader.readLine().replaceAll("\\|", "").split("\\s+-\\s+");
			LinkedHashMap<String, Long> temp = new LinkedHashMap<>();
			Long amount = Long.parseLong(tokens[1]);
			
			if (companies.containsKey(tokens[0])) {
				temp = companies.get(tokens[0]);
				if (companies.get(tokens[0]).containsKey(tokens[2])) {
					amount += temp.get(tokens[2]);
				} 
			}	
			
			temp.put(tokens[2], amount);
			companies.put(tokens[0], temp);

		}
		
		reader.close();
		
		for (Map.Entry<String, LinkedHashMap<String, Long>> s : companies.entrySet()) {
			
			StringBuffer sb = new StringBuffer();
			sb.append(s.getKey() + ": ");
			for (Map.Entry <String, Long> p : s.getValue().entrySet()) {
				sb.append(p.getKey() + "-" + p.getValue() + ", ");
			}
			
			System.out.println(sb.substring(0, sb.length() - 2));
			
		}
		
	}

}
