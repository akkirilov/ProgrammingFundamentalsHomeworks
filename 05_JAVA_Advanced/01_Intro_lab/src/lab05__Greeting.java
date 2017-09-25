import java.util.Scanner;

public class lab05__Greeting {

	private final static String MISSING_NAME = "*****";
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String firstName = scanner.nextLine();
		if (firstName.isEmpty()) {
			firstName = MISSING_NAME;
		}
		
		String lastName = scanner.nextLine();
		if (lastName.isEmpty()) {
			lastName = MISSING_NAME;
		}
		
		scanner.close();

		System.out.printf("%nHello, %s %s!%n", firstName, lastName);
		
	}

}
