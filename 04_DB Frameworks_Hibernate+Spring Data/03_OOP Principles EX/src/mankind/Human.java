package mankind;

public abstract class Human {
	
	String firstName;
	String lastName;
	
	public Human(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return "First Name: " + this.firstName;
	}

	public String getLastName() {
		return "Last Name: " + this.lastName;
	}
	
}
