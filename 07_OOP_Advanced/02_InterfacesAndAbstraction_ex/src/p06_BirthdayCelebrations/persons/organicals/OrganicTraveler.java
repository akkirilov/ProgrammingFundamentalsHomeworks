package p06_BirthdayCelebrations.persons.organicals;

import p06_BirthdayCelebrations.persons.Traveler;

public abstract class OrganicTraveler extends Traveler{

	private String name;
	private String birthDate;
	
	protected OrganicTraveler(String id, String name, String birthDate) {
		super(id);
		setName(name);
		setBirthDate(birthDate);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	private void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
}
