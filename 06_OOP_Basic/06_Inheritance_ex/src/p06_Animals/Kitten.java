package p06_Animals;

public class Kitten extends Cat {

	public Kitten(String name, String gender, int age) {
		super(name, gender, age);
		super.setSound("Miau");
	}
	
	@Override
	protected void setGender(String gender) {
		if (!gender.equals("Female")) {
			throw new IllegalArgumentException("Invalid input!");
		}
		super.setGender(gender);
	}
	
}
