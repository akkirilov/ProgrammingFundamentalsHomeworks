package ferrari;

public class Ferrari implements Car {

	public static final String MODEL = "488-Spider";
	public static final String BRAKES = "Brakes!";
	public static final String GAS_PEDAL = "Zadu6avam sA!";
		
	private String driver;
	
	public Ferrari(String driver) {
		this.driver = driver;
	}

	public String getDriver() {
		return this.driver;
	}
	
	public void print() {
		System.out.printf("%s/%s/%s/%s%n", MODEL, BRAKES, GAS_PEDAL, getDriver());
	}

}
