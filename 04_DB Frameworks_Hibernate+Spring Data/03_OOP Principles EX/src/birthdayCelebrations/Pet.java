package birthdayCelebrations;

public class Pet extends BaseControlable {
	
	private String date;
	
	public Pet(String name, String date) {
		super(name);
		this.date = date;
	}

	public String getDate () {
		return this.date;
	}
	
}
