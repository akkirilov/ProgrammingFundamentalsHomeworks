package animals;

public class Cat extends Animal{

	public Cat(String name, Integer age, String gender) {
		super(name, age, gender);
	}

	@Override
	public void produceSound() {
		System.out.println("MiauMiau");
	}

}
