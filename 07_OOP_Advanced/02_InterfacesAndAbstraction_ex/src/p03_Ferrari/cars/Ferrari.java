package p03_Ferrari.cars;

public class Ferrari implements Car {

	private final String MODEL = "488-Spider";
	
	private String driver;
	
	public Ferrari(String driver) {
		super();
		this.driver = driver;
	}

	@Override
	public String useBrakes() {
		return "Brakes!";
	}

	@Override
	public String pushGas() {
		return "Zadu6avam sA!";
	}

	@Override
	public String toString() {
		return String.format("%s/%s/%s/%s", 
				this.MODEL,
				this.useBrakes(),
				this.pushGas(),
				this.driver);
	}

}
