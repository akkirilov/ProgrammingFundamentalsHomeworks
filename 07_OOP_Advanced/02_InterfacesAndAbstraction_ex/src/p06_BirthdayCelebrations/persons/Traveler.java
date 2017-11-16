package p06_BirthdayCelebrations.persons;

public abstract class Traveler implements Identifilable {

	private String id;

	protected Traveler(String id) {
		setId(id);
	}

	private void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}
	
}
