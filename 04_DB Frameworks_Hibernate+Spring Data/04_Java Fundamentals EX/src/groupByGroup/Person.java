package groupByGroup;

public class Person {
	private String name;
	private Integer group;
	
	public Person(String name, Integer group) {
		super();
		this.name = name;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		
		return this.name;
	}
	
}
