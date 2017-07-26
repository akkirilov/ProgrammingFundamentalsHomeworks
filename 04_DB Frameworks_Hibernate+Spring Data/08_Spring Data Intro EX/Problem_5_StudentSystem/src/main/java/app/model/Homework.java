package app.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "homeworks")
public class Homework {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Basic
	private String content;
	
	@Basic
	private String type;
	
	@Column(name = "submition_date")
	private Date submitionDate;
	
	@ManyToOne()
	private Student student;

	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "course_id")
	private Course course;
	
	public Homework() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getSubmitionDate() {
		return submitionDate;
	}

	public void setSubmitionDate(Date submitionDate) {
		this.submitionDate = submitionDate;
	}

	public Student getStudent() {
		return student;
	}
    
	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}
    
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
