package animals;

public class Frog extends Animal{

	public Frog(String name, Integer age, String gender) {
		super(name, age, gender);
	}

	@Override
	public void produceSound() {
		System.out.println("Frogggg");
	}

}
