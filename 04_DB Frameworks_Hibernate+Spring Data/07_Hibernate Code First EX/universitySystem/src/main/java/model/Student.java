package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
//@DiscriminatorValue(value = "Student")
public class Student extends Person {
	
	@Column(name = "avarage_grade")
	private Double avarageGrade;
	
	@Column(name = "has_atendance")
	private boolean hasAtendance;
	
	@ManyToMany(mappedBy = "students")
	private Set<Course> courses;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String phoneNumber, Double avarageGrade, boolean hasAtendance) {
		super(firstName, lastName, phoneNumber);
		this.avarageGrade = avarageGrade;
		this.hasAtendance = hasAtendance;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Double getAvarageGrade() {
		return avarageGrade;
	}

	public void setAvarageGrade(Double avarageGrade) {
		this.avarageGrade = avarageGrade;
	}

	public boolean isHasAtendance() {
		return hasAtendance;
	}

	public void setHasAtendance(boolean hasAtendance) {
		this.hasAtendance = hasAtendance;
	}
	
}
