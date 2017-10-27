
public class Engine {

	private String model;
	private int power;
	private int displacement; 
	private String efficiency;
	
	public Engine(String model, int power) {
		super();
		this.model = model;
		this.power = power;
		this.efficiency = "n/a";
		this.displacement = -1;
	}

	public Engine(String model, int power, int displacement) {
		this(model, power);
		this.displacement = displacement;
	}
	
	public Engine(String model, int power, String efficiency) {
		this(model, power);
		this.efficiency = efficiency;
	}

	public Engine(String model, int power, int displacement, String efficiency) {
		this(model, power, displacement);
		this.efficiency = efficiency;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return String.format("  %s:%n"
				+ "    Power: %d%n"
				+ "    Displacement: %s%n"
				+ "    Efficiency: %s", 
				this.model, 
				this.power, 
				(this.displacement == -1 ? "n/a" : this.displacement),
				this.efficiency);
	}
	
	
	
	
	
}
