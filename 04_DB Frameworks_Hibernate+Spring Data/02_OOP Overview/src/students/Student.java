package students;

public class Student {
	
	public static int COUNTER = 0;
	
	private String name;

	public Student(String name) {
		this.name = name;
		COUNTER++;
	}
	
}
