package p03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
			
			String[] tokens = reader.readLine().split("\\s+");
			String firstName = tokens[0];
			String lastName = tokens[1];
			String facultyNumber = tokens[2];
			Student student = new Student(firstName, lastName, facultyNumber);
			
			tokens = reader.readLine().split("\\s+");
			firstName = tokens[0];
			lastName = tokens[1];
			double weekSalary = Double.parseDouble(tokens[2]); 
			double workHoursPerDay = Double.parseDouble(tokens[3]); 
			Worker worker = new Worker(firstName, lastName, workHoursPerDay, weekSalary);
			
			System.out.println(student);
			System.out.println(worker);
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
