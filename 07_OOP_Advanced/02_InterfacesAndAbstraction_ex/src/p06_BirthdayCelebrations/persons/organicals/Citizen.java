package p06_BirthdayCelebrations.persons.organicals;

public class Citizen extends OrganicTraveler {

	private int age;
	
	public Citizen(String id, String name, String birthDate, int age) {
		super(id, name, birthDate);
		setAge(age);
	}
	
	public int getAge() {
		return age;
	}
	
	private void setAge(int age) {
		this.age = age;
	}

	
	

	
	
}
