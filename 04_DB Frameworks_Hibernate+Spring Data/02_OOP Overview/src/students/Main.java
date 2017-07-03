package students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		String student = scanner.nextLine();
		
		while(!student.equals("End")){
			students.add(new Student(student));
			student = scanner.nextLine();
		}
		scanner.close();
		
		System.out.println(Student.COUNTER);
		
	}

}
