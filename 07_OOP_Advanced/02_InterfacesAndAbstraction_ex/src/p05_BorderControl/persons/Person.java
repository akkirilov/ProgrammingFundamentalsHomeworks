package p05_BorderControl.persons;

public abstract class Person implements Identifilable{

	private String id;

	protected Person(String id) {
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
