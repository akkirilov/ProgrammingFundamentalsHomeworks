package app.entities;

public class EmployeeNamesDto {

	private String firstName;

	private String lastName;
	
	private String street;

	public EmployeeNamesDto() {
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	
	@Override
	public String toString() {
		return String.format("firstName: %s, "
				+ "lastName: %s (%s)%n",
				firstName, lastName, street == null ? "" : street);
	}
}
