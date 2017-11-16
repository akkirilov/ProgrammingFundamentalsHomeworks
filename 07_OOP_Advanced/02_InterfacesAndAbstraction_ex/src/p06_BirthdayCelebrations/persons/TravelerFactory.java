package p06_BirthdayCelebrations.persons;

import p06_BirthdayCelebrations.persons.organicals.Citizen;
import p06_BirthdayCelebrations.persons.organicals.Pet;
import p06_BirthdayCelebrations.persons.syntheticals.Robot;

public class TravelerFactory {

	public static Traveler create(String[] tokens) {
		switch (tokens[0]) {
		case "Citizen":
			return new Citizen(tokens[3], tokens[1], tokens[4], Integer.parseInt(tokens[2]));
		case "Robot":
			return new Robot(tokens[2], tokens[1]);
		case "Pet":
			return new Pet(tokens[1], tokens[0], tokens[2]);
		default:
			return null;
		}
	}
	
}
