package students;

public class Student {
	
	private String firstName;
	private String lastName;
	private Integer group;
	
	public Student(String firstName, String lastName, Integer group) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.group = group;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getGroup() {
		return group;
	}	

}
