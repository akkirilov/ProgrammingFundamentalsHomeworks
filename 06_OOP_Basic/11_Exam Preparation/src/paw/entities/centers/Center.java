package paw.entities.centers;

public abstract class Center {
	
	private String name;
	
	Center(String name) {
		super();
		setName(name);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
