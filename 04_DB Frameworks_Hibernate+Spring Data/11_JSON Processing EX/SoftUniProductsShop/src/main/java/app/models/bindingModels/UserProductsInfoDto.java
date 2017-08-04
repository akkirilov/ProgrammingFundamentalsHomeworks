package app.models.bindingModels;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class UserProductsInfoDto implements Serializable{

	private static final long serialVersionUID = -5593554630863664401L;

	@Expose
	private String firstName;
	
	@Expose
	private String lastName;
	
	@Expose
	private Integer age;
	
	@Expose
	private SoldProductsInfoDto soldProducts;

	public UserProductsInfoDto() {
		super();
	}

	public UserProductsInfoDto(String firstName, String lastName, Integer age, SoldProductsInfoDto soldProducts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.soldProducts = soldProducts;
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

	public SoldProductsInfoDto getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(SoldProductsInfoDto soldProducts) {
		this.soldProducts = soldProducts;
	}

}
