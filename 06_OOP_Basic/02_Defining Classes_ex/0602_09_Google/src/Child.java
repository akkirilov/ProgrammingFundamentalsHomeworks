
public class Child {
	
	private String name;
	private String birthDay;
	
	public Child(String name, String birthDay) {
		super();
		this.name = name;
		this.birthDay = birthDay;
	}

	public String getName() {
		return name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	@Override
	public String toString() {
		return String.format("%s %s", name, birthDay);
	}
	
}
