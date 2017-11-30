package p02_WarningLevels;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Importance baseImportance = Importance.valueOf(scanner.nextLine().trim().toUpperCase());
		Logger logger = new Logger(baseImportance);
		
		String[] tokens = scanner.nextLine().split(":\\s+");
		while (!tokens[0].equalsIgnoreCase("END")) {
			logger.addMessage(tokens[0], tokens[1]);
			tokens = scanner.nextLine().split(":\\s+");
		}
		
		Iterable<Message> messages = logger.getMessages();
		for (Message message : messages) {
			System.out.println(message);
		}
		
		scanner.close();

	}

}
