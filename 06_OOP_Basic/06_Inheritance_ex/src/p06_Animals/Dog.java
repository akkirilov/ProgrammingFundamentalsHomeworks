package p06_Animals;

public class Dog extends Animal {

	public Dog(String name, String gender, int age) {
		super(name, gender, age);
		super.setSound("BauBau");
	}
	
}
