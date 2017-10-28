import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Person> persons = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		String name;
		String action;
		String objectName;
		String objectInfo;
		double salary;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens = reader.readLine().split("\\s+");
		while (!tokens[0].equals("End")) {

			name = tokens[0];
			action = tokens[1];
			objectName = tokens[2];
			objectInfo = tokens[3];
			
			switch (action) {
			case "company":
				salary = Double.parseDouble(tokens[4]);
				setCompany(name, objectName, objectInfo, salary);
				break;
			case "car":
				setCar(name, objectName, objectInfo);
				break;
			case "parents":
				addParent(name, objectName, objectInfo);
				break;
			case "children":
				addChild(name, objectName, objectInfo);
				break;
			case "pokemon":
				addPokemon(name, objectName, objectInfo);
				break;
			default:
				break;
			}

			tokens = reader.readLine().split("\\s+");
		}
		
		name = reader.readLine();

		reader.close();
		
		printPerson(name);

	}

	private static void printPerson(String name) {
		for (Person p : persons) {
			if (p.getName().equals(name)) {
				System.out.println(p);
				return;
			}
		}
	}

	private static void addPokemon(String name, String objectName, String objectInfo) {
		Pokemon tempPokemon = new Pokemon(objectName, objectInfo);
		for (Person p : persons) {
			if (p.getName().equals(name)) {
				p.addPokemon(tempPokemon);
				return;
			}
		}
		Person tempPerson = new Person(name);
		tempPerson.addPokemon(tempPokemon);
		persons.add(tempPerson);
	}

	private static void addChild(String name, String objectName, String objectInfo) {
		Child tempChild = new Child(objectName, objectInfo);
		for (Person p : persons) {
			if (p.getName().equals(name)) {
				p.addChild(tempChild);
				return;
			}
		}
		Person tempPerson = new Person(name);
		tempPerson.addChild(tempChild);
		persons.add(tempPerson);
	}

	private static void addParent(String name, String objectName, String objectInfo) {
		Parent tempParent = new Parent(objectName, objectInfo);
		for (Person p : persons) {
			if (p.getName().equals(name)) {
				p.addParent(tempParent);
				return;
			}
		}
		Person tempPerson = new Person(name);
		tempPerson.addParent(tempParent);
		persons.add(tempPerson);
	}

	private static void setCar(String name, String objectName, String objectInfo) {
		Car tempCar = new Car(objectName, Integer.parseInt(objectInfo));
		for (Person p : persons) {
			if (p.getName().equals(name)) {
				p.setCar(tempCar);
				return;
			}
		}
		Person tempPerson = new Person(name);
		tempPerson.setCar(tempCar);
		persons.add(tempPerson);
	}

	private static void setCompany(String name, String objectName, String objectInfo, double salary) {
		Company tempCompany = new Company(objectName, objectInfo, salary);
		for (Person p : persons) {
			if (p.getName().equals(name)) {
				p.setCompany(tempCompany);
				return;
			}
		}
		Person tempPerson = new Person(name);
		tempPerson.setCompany(tempCompany);
		persons.add(tempPerson);
	}

}
