package paw.entities.animals;

public abstract class Animal {
	
	private String name;
	private int age;
	private boolean isCleansing;
	
	Animal(String name, int age) {
		super();
		setName(name);
		setAge(age);
		this.isCleansing = false;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setAge(int age) {
		this.age = age;
	}

	public boolean getIsCleansing() {
		return isCleansing;
	}

	public void cleansing() {
		this.isCleansing = true;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
