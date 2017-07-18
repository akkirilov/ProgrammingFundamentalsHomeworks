package entity;

public class Vilain {
	
	private Long id;
	private String name;
	private String evilness;
	
	public Vilain(String name, String evilness) {
		super();
		this.name = name;
		this.evilness = evilness;
	}
	
	public Vilain(Long id, String name, String evilness) {
		super();
		this.id = id;
		this.name = name;
		this.evilness = evilness;
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

	public String getEvilness() {
		return evilness;
	}

	public void setEvilness(String evilness) {
		this.evilness = evilness;
	}
	
}
