package p05_ComparingObjects;

public class Person implements Comparable<Person>{
	
	private String name;
	private int age;
	private String town;
	
	public Person(String name, int age, String town) {
		super();
		this.name = name;
		this.age = age;
		this.town = town;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getTown() {
		return town;
	}

	@Override
	public int compareTo(Person p) {
		int res = p.getName().compareTo(this.getName());
		
		if (res == 0) {
			res = Integer.compare(p.getAge(), this.getAge());
		}
		
		if (res == 0) {
			res = p.getTown().compareTo(this.getTown());
		}
		
		return res;
	}
	
}
