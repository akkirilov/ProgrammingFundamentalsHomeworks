package animals;

public class Tomcat extends Animal{

	public Tomcat(String name, Integer age) {
		super(name, age, "Male");
	}

	@Override
	public void produceSound() {
		System.out.println("Give me one million b***h");
	}

}
