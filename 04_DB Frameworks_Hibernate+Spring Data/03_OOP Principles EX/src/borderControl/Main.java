package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Controlable> controlables = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		while (!input[0].equals("End")) {
			
			if (input.length == 2) {
				controlables.add(new Robot(input[0], input[1]));
			} else if (input.length == 3) {
				controlables.add(new Human(input[0], Integer.parseInt(input[1]), input[2]));
			}
 			
			input = scanner.nextLine().split("\\s+");
		}
		
		String fakes = scanner.nextLine();
		scanner.close();
		
		for (Controlable controlable : controlables) {
			if (controlable.getId().endsWith(fakes)) {
				System.out.println(controlable.getId());
			}
		}

	}

}
