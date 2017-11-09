package paw.entities.animals;

public abstract class Animal {
	
	private String name;
	private int age;
	private boolean isCleansing;
	
	protected Animal(String name, int age) {
		super();
		setName(name);
		setAge(age);
		this.isCleansing = false;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public void setCleansing(boolean isCleansing) {
		this.isCleansing = isCleansing;
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
