package averageGrades;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<Grade> grades;
	
	public Student(String name) {
		this.name = name;
		this.grades = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addGrade(Grade grade) {
		this.grades.add(grade);
	}
	
	public double avarageGrade () {
		double result = 0;
		for (Grade grade : grades) {
			result += grade.getGrade();
		}
		
		return result / grades.size();
	}

}
