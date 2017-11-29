package p08_PetClinics.entities;

public class Pet {
	
	private String name;
	private Integer age;
	private String kind;
	
	public Pet(String name, Integer age, String kind) {
		this.name = name;
		this.age = age;
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getKind() {
		return kind;
	}

	@Override
	public String toString() {
		return name + " " + age + " " + kind;
	}

}
