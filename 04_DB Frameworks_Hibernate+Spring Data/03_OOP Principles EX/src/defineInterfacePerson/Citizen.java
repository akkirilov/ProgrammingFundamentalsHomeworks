package defineInterfacePerson;

public class Citizen implements Person {
	
	String name;
	Integer age;
	
	public Citizen(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Integer getAge() {
		return this.age;
	}

}
