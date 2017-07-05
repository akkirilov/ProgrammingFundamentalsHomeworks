package birthdayCelebrations;

public abstract class BaseControlable implements Controlable {
	
	private String name;
	
	public BaseControlable(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
