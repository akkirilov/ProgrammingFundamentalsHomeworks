package animals;

public abstract class Animal implements Soundable {
	
	private String name;
	private Integer age;
	private String gender;	
	
	public Animal(String name, Integer age, String gender) {
		this.setName(name);
		this.setAge(age);
		this.setGender(gender);
	}
	
	@Override
    public String toString() {
        return String.format("%s%n%s %d %s%n",
        		this.getClass().getSimpleName(),
        		this.getName(),
        		this.getAge(),
        		this.getGender());
    }

	@Override
    public void produceSound() {
        System.out.println("Not implemented!");
    }

	public String getName() {
		return this.name;
	}

	public Integer getAge() {
		return this.age;
	}

	public String getGender() {
		return this.gender;
	}

	private void setName(String name) {
		if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
	}

	private void setAge(Integer age) {
		if (age == null || age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
		this.age = age;
	}

	private void setGender(String gender) {
		if (gender == null || gender.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
		this.gender = gender;
	}
	
}
