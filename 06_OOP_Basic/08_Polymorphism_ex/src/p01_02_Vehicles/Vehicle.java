package p01_02_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
	
	protected final DecimalFormat PRINT_DISTANCE_FORMAT = new DecimalFormat("#.##");
	
	private double fuelQuantity; 
	private double fuelConsumption;
	private double tankCapacity;
	
	public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
		super();
		setFuelQuantity(fuelQuantity);
		setFuelConsumption(fuelConsumption);
		setTankCapacity(tankCapacity);
	}

	protected final double getFuelQuantity() {
		return fuelQuantity;
	}
	
	protected void setFuelQuantity(double fuelQuantity) {
		this.fuelQuantity = fuelQuantity;
	}
	
	protected final double getFuelConsumption() {
		return fuelConsumption;
	}
	
	private void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
	protected double getTankCapacity() {
		return tankCapacity;
	}

	private void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

	protected abstract String drive(double distance);
	
	protected abstract void refuel(double fuelQuantity);

	@Override
	public String toString() {
		return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
	}

	
	
}
