package exellentStudents;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		
		List<Student> students = new ArrayList<>();
		while (!input[0].equals("END")) {
			List<Double> tempGrades = new ArrayList<>();
			for (int i = 2; i < input.length; i++) {
				tempGrades.add(Double.parseDouble(input[i]));
			}
			students.add(new Student(input[0], input[1], tempGrades ));
			
			input = scanner.nextLine().split("\\s+");
		}
		scanner.close();
		
		students.stream()
			.filter(s -> s.isAnyExellentMark())
			.forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
		
	} 

}
