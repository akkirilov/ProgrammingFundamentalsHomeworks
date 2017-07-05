package mankind;

public class Student extends Human {

	String facultyNumber;
	
	public Student(String firstName, String lastName, String facultyNumber) {
		super(firstName, lastName);
		this.facultyNumber = facultyNumber;
	}
	
	public String getfacultyNumber() {
		return "Faculty number: " + this.facultyNumber;
	}

}
