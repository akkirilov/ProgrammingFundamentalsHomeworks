package p06_StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		TreeSet<Person> personsByName = new TreeSet<>(new NameComparator());
		TreeSet<Person> personsByAge = new TreeSet<>(new AgeComparator());
		
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < number; i++) {
			String[] tokens = scanner.nextLine().split("\\s+");
			personsByName.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
			personsByAge.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
		}
		scanner.close();
		
		for (Person p : personsByName) {
			System.out.println(p);
		}
		for (Person p : personsByAge) {
			System.out.println(p);
		}

	}

}
