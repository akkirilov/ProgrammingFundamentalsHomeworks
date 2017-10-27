
public class Car {
	
	private static final int DEFAULT_DISTANCE = 0;

	private String model;
	private double fuel;
	private double fuelPerKM;
	private int distanceTraveled;
	
	public Car(String model, double fuel, double fuelPerKM) {
		super();
		this.model = model;
		this.fuel = fuel;
		this.fuelPerKM = fuelPerKM;
		this.distanceTraveled = DEFAULT_DISTANCE;
	}
	
	public String getModel() {
		return model;
	}

	public String tryToDriveCar (int distance) {
		
		if (this.fuel - (distance * this.fuelPerKM) < 0) {
			return "Insufficient fuel for the drive";
		}
		
		this.fuel -= (distance * this.fuelPerKM);
		this.distanceTraveled += distance;
		
		return "ok";
		
	}

	@Override
	public String toString() {
		return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
	}

	
	
}
