package p02_MultipleImplementation.persons;

public class Citizen implements Person, Identifiable, Birthable {
	
	private String name;
	private int age;
	private String id;
	private String birthdate;
	
	public Citizen(String name, int age, String id, String birthdate) {
		super();
		this.setName(name);
		this.setAge(age);
		this.setId(id);
		this.setBirthdate(birthdate);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public String getBirthdate() {
		return this.birthdate;
	}

	@Override
	public String getId() {
		return this.id;
	}

}
