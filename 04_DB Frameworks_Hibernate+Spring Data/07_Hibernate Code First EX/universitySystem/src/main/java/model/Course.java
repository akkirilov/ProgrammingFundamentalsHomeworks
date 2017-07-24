package model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	
	@Id
	private String name;
	
	@Basic
	private String description;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Basic
	private Integer credits;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "students_courses", 
			joinColumns = @JoinColumn(name = "course_name", referencedColumnName = "name"),
			inverseJoinColumns = @JoinColumn(name = "sudent_id", referencedColumnName = "id"))
	private Set<Student> students;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "id")
	private Teacher teacher;

	public Course(String name, String description, Date startDate, Date endDate, Integer credits) {
		super();
		this.name = name;
		this.description = description;
		this.endDate = endDate;
		this.startDate = startDate;
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
