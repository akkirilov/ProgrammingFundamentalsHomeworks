package borderControl;

public abstract class BaseControlable implements Controlable {
	
	private String name;
	private String id;
	
	public BaseControlable(String name, String id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getId() {
		return this.id;
	}

}
