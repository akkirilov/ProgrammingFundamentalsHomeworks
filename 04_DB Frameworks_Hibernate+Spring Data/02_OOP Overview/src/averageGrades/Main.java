package averageGrades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			String[] input = scanner.nextLine().split("\\s+");
			
			Student temp = new Student(input[0]);
			
			for (int j = 1; j < input.length; j++) {
				temp.addGrade(new Grade(Double.parseDouble(input[j])));
			}
			
			students.add(temp);
		}
		scanner.close();
		
		students.stream()
				.filter(s -> s.avarageGrade() >= 5)
				.sorted((a, b) -> {
									int result = a.getName().compareTo(b.getName());
									if (result == 0) {
										result = Double.compare(b.avarageGrade(), a.avarageGrade());
									}
									return result;
								})
				.forEach(s -> {
								System.out.printf("%s -> %.2f%n", s.getName(), s.avarageGrade());
							});

	}

}
