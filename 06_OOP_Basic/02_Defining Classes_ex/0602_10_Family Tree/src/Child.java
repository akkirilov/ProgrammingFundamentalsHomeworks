
public class Child {
	
	private String name;
	private String birthDate;
	
	public Child() {
		super();
		this.name = "";
		this.birthDate = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("%s %s", name, birthDate);
	}
	
}
