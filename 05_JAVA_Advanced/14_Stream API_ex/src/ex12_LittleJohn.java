import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ex12_LittleJohn {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> arrows = new LinkedHashMap<>();
		arrows.put("small", 0);
		arrows.put("medium", 0);
		arrows.put("large", 0);
		
		Integer counter = 0;
		String input = reader.readLine();
		while (true) {
			
			if (input.contains(">>>----->>")) {
				input = input.substring(input.indexOf(">>>----->>") + 10, input.length());
				arrows.put("large", arrows.get("large") + 1);
				continue;
			} else if (input.contains(">>----->")) {
				input = input.substring(input.indexOf(">>----->") + 8, input.length());
				arrows.put("medium", arrows.get("medium") + 1);
				continue;
			} else if (input.contains(">----->")) {
				input = input.substring(input.indexOf(">----->") + 7, input.length());
				arrows.put("small", arrows.get("small") + 1);
				continue;
			}
			
			counter++;
			if (counter == 4) {
				break;
			}
			
			input = reader.readLine();
			
		}
		
		reader.close();
		
		StringBuffer resultString = new StringBuffer ("" + arrows.get("small") + arrows.get("medium") + arrows.get("large")); 
		Integer resultInteger = Integer.parseInt(resultString.toString());
		resultString = new StringBuffer();
		resultString.append(Integer.toBinaryString(resultInteger));
		resultString = resultString.reverse();
		resultString.insert(0, Integer.toBinaryString(resultInteger));

		System.out.println(Integer.parseInt(resultString.toString(), 2));
		
	}

}
