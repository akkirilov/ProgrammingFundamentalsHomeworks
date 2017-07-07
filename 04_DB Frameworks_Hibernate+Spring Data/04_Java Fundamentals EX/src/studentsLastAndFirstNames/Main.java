package studentsLastAndFirstNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		
		List<Student> students = new ArrayList<>();
		while (!input[0].equals("END")) {
			students.add(new Student(input[0], input[1]));
			
			input = scanner.nextLine().split("\\s+");
		}
		scanner.close();
		
		students.stream()
			.sorted((a, b) -> {
				int result = a.getLastName().compareTo(b.getLastName());
				if (result == 0) {
					result = b.getFirstName().compareTo(a.getFirstName());
				}
				return result;
			})
			.forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
		
	} 

}
