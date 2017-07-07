package enrolledStudents;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		
		List<Student> students = new ArrayList<>();
		while (!input[0].equals("END")) {
			List<Integer> tempGrades = new ArrayList<>();
			for (int i = 1; i < input.length; i++) {
				tempGrades.add(Integer.parseInt(input[i]));
			}
			students.add(new Student(input[0], tempGrades ));
			
			input = scanner.nextLine().split("\\s+");
		}
		scanner.close();
		
		students.stream()
			.filter(s -> s.getFacultyNumber().endsWith("14") || s.getFacultyNumber().endsWith("15"))
			.forEach(s -> {
							s.getGrades()
							.stream()
							.forEach(g -> System.out.print(g + " "));
							System.out.println();
						});
		
	} 

}
