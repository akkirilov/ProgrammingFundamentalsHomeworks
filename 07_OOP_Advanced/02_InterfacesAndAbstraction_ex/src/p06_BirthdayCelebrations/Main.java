package p06_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import p06_BirthdayCelebrations.persons.Traveler;
import p06_BirthdayCelebrations.persons.TravelerFactory;
import p06_BirthdayCelebrations.persons.organicals.OrganicTraveler;

public class Main {

	public static void main(String[] args) {
		
		List<Traveler> travelers = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		String[] tokens = scanner.nextLine().split("\\s+");
		while (!tokens[0].equals("End")) {
			travelers.add(TravelerFactory.create(tokens));
			tokens = scanner.nextLine().split("\\s+");
		}
		
		String year = scanner.nextLine();
		
		scanner.close();
		
		for (Traveler t : travelers) {
			if (t.getClass().getSimpleName().equals("Robot")) {
				continue;
			} 
			if (((OrganicTraveler) t).getBirthDate().endsWith(year)) {
				System.out.println(((OrganicTraveler) t).getBirthDate());
			}
		}
		
	}

}
