package p05_BorderControl.persons;

public class Robot extends Person {

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
