package avatar.entities.monuments;

public abstract class Monument {

	private String name;

	public Monument(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public abstract int getAffinity(); 
	
}
