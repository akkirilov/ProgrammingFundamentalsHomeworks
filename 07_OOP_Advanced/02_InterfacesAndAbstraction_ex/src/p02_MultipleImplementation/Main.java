package p02_MultipleImplementation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

import p02_MultipleImplementation.persons.Birthable;
import p02_MultipleImplementation.persons.Citizen;
import p02_MultipleImplementation.persons.Identifiable;

public class Main {
	public static void main(String[] args) {

		@SuppressWarnings("rawtypes")
		Class[] citizenInterfaces = Citizen.class.getInterfaces();
		if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
				&& Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
			
			Method[] methods = Birthable.class.getDeclaredMethods();
			methods = Identifiable.class.getDeclaredMethods();
			
			Scanner scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			int age = Integer.parseInt(scanner.nextLine());
			String id = scanner.nextLine();
			String birthdate = scanner.nextLine();
			
			Identifiable identifiable = new Citizen(name, age, id, birthdate);
			Birthable birthable = new Citizen(name, age, id, birthdate);
			
			System.out.println(methods.length);
			System.out.println(methods[0].getReturnType().getSimpleName());
			System.out.println(methods.length);
			System.out.println(methods[0].getReturnType().getSimpleName());
			
			scanner.close();
		}

	}

}
