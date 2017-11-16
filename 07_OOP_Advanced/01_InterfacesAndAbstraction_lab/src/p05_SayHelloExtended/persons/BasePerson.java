package p05_SayHelloExtended.persons;

class BasePerson implements Person {

	private String name;

	protected BasePerson(String name) {
		this.setName(name);
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;

	}
}
