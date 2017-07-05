package birthdayCelebrations;

public class Robot extends BaseControlable {
	
	private String id;
	
	public Robot(String name, String id) {
		super(name);
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
	
}
