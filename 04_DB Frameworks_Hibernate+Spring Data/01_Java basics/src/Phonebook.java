import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

	public static void main(String[] args) {
		Map<String, String> phones = new HashMap<>();
		
		Scanner scanner = new Scanner(System.in);
		String[] tokens = scanner.nextLine().split("\\s+");
		
		while (!tokens[0].equals("END")) {
			
			if (tokens[0].equals("A")) {
				phones.put(tokens[1], tokens[2]);
			} else if (tokens[0].equals("S")) {
				if (phones.containsKey(tokens[1])) {
					System.out.printf("%s -> %s%n", tokens[1], phones.get(tokens[1]));
				} else {
					System.out.printf("Contact %s does not exist.%n", tokens[1]);
				}
			}
			
			tokens = scanner.nextLine().split("\\s+");
		}
		
		scanner.close();
		
	}

}
