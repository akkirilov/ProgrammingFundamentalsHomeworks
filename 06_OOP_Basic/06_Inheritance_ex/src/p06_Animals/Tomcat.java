package p06_Animals;

public class Tomcat extends Cat {

	public Tomcat(String name, String gender, int age) {
		super(name, gender, age);
		super.setSound("Give me one million b***h");
	}
	
	@Override
	protected void setGender(String gender) {
		if (!gender.equals("Male")) {
			throw new IllegalArgumentException("Invalid input!");
		}
		super.setGender(gender);
	}
	
}
