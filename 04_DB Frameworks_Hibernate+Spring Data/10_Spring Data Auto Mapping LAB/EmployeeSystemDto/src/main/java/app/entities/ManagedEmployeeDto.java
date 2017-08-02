package app.entities;

import java.math.BigDecimal;

public class ManagedEmployeeDto {

	private String firstName;

	private String lastName;

	private BigDecimal salary;

	public ManagedEmployeeDto() {
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

	@Override
	public String toString() {
		return String.format("%s %s %.2f%n",
				firstName, lastName, salary);
	}
}
