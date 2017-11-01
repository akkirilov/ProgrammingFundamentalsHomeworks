package p03_Mankind;

public class Human {
	
	private String firstName;
	private String lastName;
	
	protected Human(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	protected String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		if (firstName.length() < 4) {
			throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
		}			
		if (!Character.isUpperCase(firstName.charAt(0))) {
			throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
		}
		this.firstName = firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		if (lastName.length() < 3) {
			throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
		}			
		if (!Character.isUpperCase(lastName.charAt(0))) {
			throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
		}
		this.lastName = lastName;
	}

}
