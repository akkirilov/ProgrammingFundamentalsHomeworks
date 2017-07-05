package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Controlable> controlables = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		while (!input[0].equals("End")) {
			
			if (input.length == 3) {
				if (input[0].equals("Pet")) {
					controlables.add(new Pet(input[1], input[2]));
				} else {
					controlables.add(new Robot(input[1], input[2]));
				}
			} else if (input.length == 5) {
				controlables.add(new Human(input[1], Integer.parseInt(input[2]), input[3], input[4]));
			}
 			
			input = scanner.nextLine().split("\\s+");
		}
		
		String year = scanner.nextLine();
		scanner.close();
		
		for (Controlable controlable : controlables) {
			if (controlable.getClass().getSimpleName().equals("Pet") 
					&& ((Pet)controlable).getDate().endsWith(year)) {
				System.out.println(((Pet) controlable).getDate());
			} else if (controlable.getClass().getSimpleName().equals("Human") 
					&& ((Human)controlable).getDate().endsWith(year)) {
				System.out.println(((Human) controlable).getDate());
			}
		}

	}

}
