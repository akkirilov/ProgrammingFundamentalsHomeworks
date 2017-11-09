package paw.entities.centers;

public abstract class Center {
	
	private String name;
	
	protected Center(String name) {
		setName(name);
	}

	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
