
public class Parent {
	
	private String name;
	private String birthDay;
	
	public Parent(String name, String birthDay) {
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
