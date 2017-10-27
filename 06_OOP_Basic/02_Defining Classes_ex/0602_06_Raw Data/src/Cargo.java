
public class Cargo {

	private String type;
	private int weight;
	
	public Cargo(String type, int weight) {
		super();
		this.type = type;
		this.weight = weight;
	}

	public Cargo(int weight, String type) {
		this.type = type;
		this.weight = weight;
	}

	public String getType() {
		return type;
	}
	
}
