
public class Chicken {

	private String name;
	private int age;
	
	public Chicken(String name, int age) {
		super();
		setName(name);
		setAge(age);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (name == null || name.length() < 1 || name.isEmpty() || name.equals(" ")) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		if (age < 0 || age > 15) {
			throw new IllegalArgumentException("Age should be between 0 and 15.");
		}
		this.age = age;
	}
	
	public String calculateProductPerDay() {
		if (this.age < 6) {
			return "2";
		} else if (this.age < 12) {
			return "1";
		} else {
			return "0.75";
		}
	}

	@Override
	public String toString() {
		return String.format("Chicken %s (age %d) can produce %s eggs per day.", 
				this.name, 
				this.age, 
				this.calculateProductPerDay());
	}
	
}
