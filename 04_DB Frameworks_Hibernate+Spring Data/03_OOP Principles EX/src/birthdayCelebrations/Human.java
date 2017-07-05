package birthdayCelebrations;

public class Human extends BaseControlable {
		
	private int age;
	private String id;
	private String date; 
		
	public Human(String name, int age, String id, String date) {
		super(name);
		this.id = id;
		this.age = age;
		this.date = date;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getId() {
		return this.id;
	}

	public String getDate () {
		return this.date;
	}
	
}
