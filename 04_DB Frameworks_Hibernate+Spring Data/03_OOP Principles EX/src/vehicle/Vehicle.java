package vehicle;

public abstract class Vehicle implements VehicleInterface{
	private Double fuelQuantity;
	private Double fuelConsumption;
	public Double distance = 0.0;
	
	public Vehicle(Double fuelQuantity, Double fuelConsumption) {
		this.fuelQuantity = fuelQuantity;
		this.fuelConsumption = fuelConsumption;
	}

	@Override
	public Double getFuelQuantity() {
		return fuelQuantity;
	}

	@Override
	public void refuel(Double refuel) {
		this.fuelQuantity += refuel;
	}
	
	@Override
	public void drive(Double drive) {
		this.fuelQuantity -= drive;
	}

	@Override
	public Double getFuelConsumption() {
		return fuelConsumption;
	}

	@Override
	public Double getDistance() {
		return distance;
	}

	@Override
	public void addDistance(Double distance) {
		this.distance += distance;
	}
	
}
