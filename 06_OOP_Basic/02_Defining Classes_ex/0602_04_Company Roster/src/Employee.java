
public class Employee {
	
	private String name;
	private int age;
	private double salary;
	private String position; 
	private String email; 

	public Employee(String name, double salary, String position) {
		super();
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.age = -1;
		this.email = "n/a";
	}

	public Employee(String name, int age, double salary, String position) {
		this(name, salary, position);
		this.age = age;
	}

	public Employee(String name, double salary, String position, String email) {
		this(name, salary, position);
		this.email = email;
	}

	public Employee(String name, int age, double salary, String position, String email) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.position = position;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
