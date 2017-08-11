package app.domain.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import app.domain.enums.Gender;

@Entity
@Table(name = "persons")
public class Person implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Length(min = 1, max = 60)
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Length(min = 1, max = 1)	
	@Column(name = "middle_name")
	private String middleName;
	
	@NotNull
	@Length(min = 2)
	@Column(name = "last_name")
	private String lastName;
	
	@Transient
	private String fullName;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Basic
	private Gender gender;
	
	@Column(name = "bitrth_date")
	private Date birthDate;
	
	@Basic
	private String phone;
	
	@Pattern(regexp = "[0-9a-zA-Z]+@[a-z]+\\.[a-z]+")
	@Basic
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
