package borderControl;

public class Human extends BaseControlable {
		
	private int age;
		
	public Human(String name, int age, String id) {
		super(name, id);
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}

}
