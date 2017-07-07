package studentsByPhone;

public class Student {
	
	private String firstName;
	private String lastName;
	private String phone;
	
	public Student(String firstName, String lastName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getPhone() {
		return phone;
	}
	
}
