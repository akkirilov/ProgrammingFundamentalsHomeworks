import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ex11_Phonebook {

	public static void main(String[] args) throws IOException {
		
		Map<String, String> phonebook = new HashMap<>();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			
			String[] input = bfr.readLine().split("\\-");
			if (input[0].equals("search")) {
				break;
			} else {
				phonebook.put(input[0], input[1]);
			}
			
		}
		
		String input = bfr.readLine();
		while (!input.equals("stop")) {
						
			if (phonebook.containsKey(input)) {
				System.out.printf("%s -> %s%n", input, phonebook.get(input));
			} else {
				System.out.printf("Contact %s does not exist.%n", input);
			}
			
			input = bfr.readLine();
			
		}
		
		
		bfr.close();
		
	}

}
