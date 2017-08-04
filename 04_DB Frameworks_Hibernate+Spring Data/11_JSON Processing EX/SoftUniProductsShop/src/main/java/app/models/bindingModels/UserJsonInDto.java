package app.models.bindingModels;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class UserJsonInDto implements Serializable{

	private static final long serialVersionUID = -6816244753026670213L;

	@Expose
	private String firstName;
	
	@Expose
	private String lastName;
	
	@Expose
	private Integer age;

	public UserJsonInDto() {
		super();
	}

	public UserJsonInDto(String firstName, String lastName, Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
