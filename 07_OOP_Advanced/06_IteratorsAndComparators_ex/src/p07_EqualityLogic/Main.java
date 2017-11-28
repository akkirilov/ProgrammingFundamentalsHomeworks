package p07_EqualityLogic;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Set<Person> personsInTree = new TreeSet<>();
		Set<Person> personsInHash = new HashSet<>();
		
		Scanner scanner = new Scanner(System.in);
		
		int number = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < number; i++) {
			String[] tokens = scanner.nextLine().split("\\s+");
			personsInTree.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
			personsInHash.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
		}
		
		scanner.close();
		
		System.out.println(personsInTree.size());
		System.out.println(personsInHash.size());

	}

}
