package exellentStudents;

import java.util.List;

public class Student {
	
	private String firstName;
	private String lastName;
	private List<Double> grades;
	
	public Student(String firstName, String lastName, List<Double> grades) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grades = grades;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public List<Double> getGrades() {
		return grades;
	}
	
	public boolean isAnyExellentMark() {
		return this.grades
				.stream()
				.anyMatch(g -> g == 6);
	}
	
}
