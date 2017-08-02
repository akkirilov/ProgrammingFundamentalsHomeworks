package app.entities;

import java.math.BigDecimal;

public class EmployeeDto {

	private String firstName;

	private String lastName;

	private BigDecimal salary;
	
	private String addressStreet;

	private String addressCityName;

	public EmployeeDto() {
		super();
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressCityName() {
		return addressCityName;
	}

	public void setAddressCityName(String addressCityName) {
		this.addressCityName = addressCityName;
	}

	@Override
	public String toString() {
		return String.format("firstName: %s%n"
				+ "lastName: %s%n"
				+ "salary: %.2f%n"
				+ "street: %s%n"
				+ "city: %s%n", 
				firstName, lastName, salary, 
				addressStreet,addressCityName);
	}
}
