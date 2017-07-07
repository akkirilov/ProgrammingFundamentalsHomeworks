package students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		
		List<Student> students = new ArrayList<>();
		while (!input[0].equals("END")) {
			students.add(new Student(input[0], input[1], Integer.parseInt(input[2])));
			
			input = scanner.nextLine().split("\\s+");
		}
		scanner.close();
		
		students.stream()
			.filter(s -> s.getGroup() == 2)
			.sorted((a, b) -> a.getFirstName().compareTo(b.getFirstName()))
			.forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
		
	} 

}
