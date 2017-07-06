package vehicle;

public interface VehicleInterface {
	public Double getFuelQuantity();

	public void refuel(Double refuel);
	
	public void drive(Double drive);

	public Double getFuelConsumption();

	public Double getDistance();
	
	public void addDistance(Double distance);
}
