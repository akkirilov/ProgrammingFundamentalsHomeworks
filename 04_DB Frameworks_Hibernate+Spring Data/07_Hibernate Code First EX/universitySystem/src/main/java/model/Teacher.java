package model;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
//@DiscriminatorValue(value = "Teacher")
public class Teacher extends Person {
	
	@Basic
	private String email;
	
	@Column(name = "salary_per_hour")
	private Double salaryPerHour;
	
	@OneToMany(mappedBy = "teacher")
	private Set<Course> courses;

	public Teacher() {
		super();
	}

	public Teacher(String firstName, String lastName, String phoneNumber, String email, Double salaryPerHour) {
		super(firstName, lastName, phoneNumber);
		this.email = email;
		this.salaryPerHour = salaryPerHour;
	}

	public Set<Course> getCourse() {
		return this.courses;
	}

	public void setCourse(Set<Course> courses) {
		this.courses = courses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalaryPerHour() {
		return salaryPerHour;
	}

	public void setSalaryPerHour(Double salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}
	
}
