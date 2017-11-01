package p06_Animals;

public class Cat extends Animal {

	public Cat(String name, String gender, int age) {
		super(name, gender, age);
		super.setSound("MiauMiau");
	}

	@Override
	protected void setGender(String gender) {
		super.setGender(gender);
	}
	
	
	
}
