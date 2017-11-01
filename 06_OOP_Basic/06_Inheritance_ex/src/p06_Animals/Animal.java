package p06_Animals;

public class Animal {
	
	private String name;
	private String gender;
	private int age;
	private String sound;
	
	public Animal(String name, String gender, int age) {
		super();
		setName(name);
		setGender(gender);
		setAge(age);
		this.sound = "Not implemented!";
	}

	protected void setSound(String sound) {
		this.sound = sound;
	}
	
	private String produceSound() {
		return sound;
	}

	private void setName(String name) {
		if (name == null || name.trim().length() < 1 || name.trim().equals(" ")) {
			throw new IllegalArgumentException("Invalid input!");
		}
		this.name = name;
	}

	protected void setGender(String gender) {
		if (gender == null || (!gender.equals("Male") && !gender.equals("Female")) || gender.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid input!");
		}
		this.gender = gender;
	}

	private void setAge(int age) {
		if (age <= 0) {
			throw new IllegalArgumentException("Invalid input!");
		}
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName().toString(), name, age, gender, this.produceSound());
	}
	
	
}
