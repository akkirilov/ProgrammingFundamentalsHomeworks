package app.domain.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import app.domain.enums.Gender;

@Entity
@Table(name = "")
public class Person implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Length(min = 1, max = 60)
	@Column(name = "first_name", length = 60)
	private String firstName;
	
	@NotNull
	@Length(min = 1, max = 1)
	@Column(name = "middle_name", length = 1)
	private String middleName;
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "phone")
	private String phone;
	
	@Pattern(regexp = "[a-zA-Z0-9]+@[a-z]+\\.[a-z]+")
	@Column(name = "email")
	private String email;

	public Person() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	public Integer getAge() {
		Integer age;;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		age = calendar.get(Calendar.YEAR);
		calendar.clear();
		calendar.setTime(birthDate);
		age -= calendar.get(Calendar.YEAR);

		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
