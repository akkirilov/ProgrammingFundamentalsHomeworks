package enrolledStudents;

import java.util.List;

public class Student {
	
	private String facultyNumber;
	private List<Integer> grades;
	
	public Student(String facultyNumber, List<Integer> grades) {
		this.facultyNumber = facultyNumber;
		this.grades = grades;
	}

	public String getFacultyNumber() {
		return this.facultyNumber;
	}
	public List<Integer> getGrades() {
		return grades;
	}
	
}
