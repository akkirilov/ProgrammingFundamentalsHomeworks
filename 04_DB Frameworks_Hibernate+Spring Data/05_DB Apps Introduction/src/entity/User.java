package entity;

import java.sql.Date;

public class User {
	private Long id;
	private String name;
	private int age;
	private Date registrationDate;
	
	public User(String name, int age, Date registrationDate) {
		super();
		this.name = name;
		this.age = age;
		this.registrationDate = registrationDate;
	}

	public User(long id, String name, int age, Date registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.registrationDate = registrationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
		
}
