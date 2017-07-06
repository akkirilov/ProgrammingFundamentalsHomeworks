package animals;

public class Kitten extends Animal{

	public Kitten(String name, Integer age) {
		super(name, age, "Female");
	}
	
	@Override
	public void produceSound() {
		System.out.println("Miau");
	}

}
