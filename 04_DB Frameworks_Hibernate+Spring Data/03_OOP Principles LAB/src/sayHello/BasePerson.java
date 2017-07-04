package sayHello;

public abstract class BasePerson implements Person {
	
	private String name;
	
	public BasePerson(String name){
		setName(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
