package vehicle;

public abstract class Vehicle {
	private Double fuelQuantity;
	private Double fuelConsumption;
	public Double distance = 0.0;
	
	public Vehicle(Double fuelQuantity, Double fuelConsumption) {
		this.fuelQuantity = fuelQuantity;
		this.fuelConsumption = fuelConsumption;
	}

	public Double getFuelQuantity() {
		return fuelQuantity;
	}

	public void refuel(Double refuel) {
		this.fuelQuantity += refuel;
	}
	
	public void drive(Double drive) {
		this.fuelQuantity -= drive;
	}

	public Double getFuelConsumption() {
		return fuelConsumption;
	}

	public Double getDistance() {
		return distance;
	}

	public void addDistance(Double distance) {
		this.distance += distance;
	}
	
	

}
