package animals;

public class Dog extends Animal{

	public Dog(String name, Integer age, String gender) {
		super(name, age, gender);
	}

	@Override
	public void produceSound() {
		System.out.println("BauBau");
	}

}
