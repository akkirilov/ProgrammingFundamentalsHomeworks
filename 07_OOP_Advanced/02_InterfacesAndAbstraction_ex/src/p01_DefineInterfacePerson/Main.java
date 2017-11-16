package p01_DefineInterfacePerson;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

import p01_DefineInterfacePerson.persons.Citizen;
import p01_DefineInterfacePerson.persons.Person;

public class Main {
	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		Class[] citizenInterfaces = Citizen.class.getInterfaces();
		
		if (Arrays.asList(citizenInterfaces).contains(Person.class)) {
			Method[] fields = Person.class.getDeclaredMethods();
			
			Scanner scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			int age = Integer.parseInt(scanner.nextLine());
			
			scanner.close();
			
			Person person = new Citizen(name, age);
			
			System.out.println(fields.length);
			System.out.println(person.getName());
			System.out.println(person.getAge());
			
		}
	}

}
