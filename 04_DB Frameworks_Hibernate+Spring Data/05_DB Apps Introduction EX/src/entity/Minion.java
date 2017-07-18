package entity;

public class Minion {
	
	private Long id;
	private String name;
	private Integer age;
	private Long townId;
	
	public Minion(String name, Integer age, Long townId) {
		super();
		this.name = name;
		this.age = age;
		this.townId = townId;
	}

	public Minion(Long id, String name, Integer age, Long townId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.townId = townId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}
	
}
