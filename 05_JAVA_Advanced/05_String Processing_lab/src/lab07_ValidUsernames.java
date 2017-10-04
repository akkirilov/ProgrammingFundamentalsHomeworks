import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class lab07_ValidUsernames {

	public static void main(String[] args) {
		
		Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
		List<String> usernames = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);
		
		Boolean found = false;
		String input = scanner.nextLine();
		while (!input.equals("END")) {
			
			if (!found && pattern.matcher(input).find()) {
				found = true;
			}
			
			usernames.add(input);
            input = scanner.nextLine();
            
        }
		
		scanner.close();
		
		if (!found) {
			return;
		}

		for (int i = 0; i < usernames.size(); i++) {
			
        	if (pattern.matcher(usernames.get(i)).find()) {
        		System.out.println("valid");
			} else {
				System.out.println("invalid");
			}
        	
        }
                
	}

}
