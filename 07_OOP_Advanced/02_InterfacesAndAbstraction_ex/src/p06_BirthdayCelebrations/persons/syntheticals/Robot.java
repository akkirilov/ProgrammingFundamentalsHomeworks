package p06_BirthdayCelebrations.persons.syntheticals;

import p06_BirthdayCelebrations.persons.Traveler;

public class Robot extends Traveler {

	private String model;

	public Robot(String id, String model) {
		super(id);
		setModel(model);
	}

	public String getModel() {
		return model;
	}

	private void setModel(String model) {
		this.model = model;
	}
	
}
