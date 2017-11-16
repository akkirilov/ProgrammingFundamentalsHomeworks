package p05_BorderControl.persons;

public class PersonFactory {

	public static Person create(String[] tokens) {
		if (tokens.length == 3) {
			return new Citizen(tokens[2], tokens[0], Integer.parseInt(tokens[1]));
		} else {
			return new Robot(tokens[1], tokens[0]);
		}
	}
	
}
