package p05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		List<Person> persons =  new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);

		String[] tokens = scanner.nextLine().split("\\s+");
		while (!tokens[0].equals("END")) {
			persons.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
			tokens = scanner.nextLine().split("\\s+");		
		}
		
		int num = Integer.parseInt(scanner.nextLine()) - 1;
		
		scanner.close();
		
		Person p = persons.get(num);
		
		int equals = 1;
		int notEquals = 0;
		for (int i = 0; i < persons.size(); i++) {
			if (i == num) {
				continue;
			}
			
			if (p.compareTo(persons.get(i)) == 0) {
				equals++;
			} else {
				notEquals++;
			}
		}
		
		if (equals == 1) {
			System.out.println("No matches");
		} else {
			System.out.println(equals + " " + notEquals + " " + persons.size());
		}
		
	}

}
