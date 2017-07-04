package sayHello;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Bulgarian("Pesho"));
		persons.add(new Chinese("Wang"));
		persons.add(new European("Mark"));

		for (Person person : persons) {
			print(person);
		}
		
	}
	
	private static void print(Person person) {
		System.out.printf("%s(%s): \"%s\"%n", 
				person.getName(), 
				person.getClass().getSimpleName(), 
				person.sayHello());
	}

}
