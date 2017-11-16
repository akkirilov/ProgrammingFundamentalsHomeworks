package p05_BorderControl.persons;

public class Citizen extends Person {

	private String name;
	private int age;
	
	public Citizen(String id, String name, int age) {
		super(id);
		setName(name);
		setAge(age);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}
	
}
