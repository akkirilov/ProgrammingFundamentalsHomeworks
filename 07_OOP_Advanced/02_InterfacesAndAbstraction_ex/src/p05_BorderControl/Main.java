package p05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import p05_BorderControl.persons.Person;
import p05_BorderControl.persons.PersonFactory;

public class Main {

	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		String[] tokens = scanner.nextLine().split("\\s+");
		while (!tokens[0].equals("End")) {
			persons.add(PersonFactory.create(tokens));
			tokens = scanner.nextLine().split("\\s+");
		}
		
		String fakeIdEnds = scanner.nextLine();
		
		scanner.close();
		
		for (Person p : persons) {
			if (p.getId().endsWith(fakeIdEnds)) {
				System.out.println(p.getId());
			}
		}
		
	}

}
