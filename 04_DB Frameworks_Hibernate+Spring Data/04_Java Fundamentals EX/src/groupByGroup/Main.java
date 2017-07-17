package groupByGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		
		List<Person> persons = new ArrayList<Person>();
		while (!input[0].equals("END")) {
			persons.add(new Person(input[0] + " " + input[1], Integer.parseInt(input[2])));
			
			input = scanner.nextLine().split("\\s+");
		}
		scanner.close();
		
		persons.stream()
		.collect(Collectors.groupingBy(p -> p.getGroup()))
				.entrySet().stream()
				.forEach(x -> System.out.printf("%s - %s%n", 
						x.getKey(), 
						String.format("%s", 
							x.getValue()).substring(1, String.format("%s", x.getValue()).length() - 1)));
		
	}

}
